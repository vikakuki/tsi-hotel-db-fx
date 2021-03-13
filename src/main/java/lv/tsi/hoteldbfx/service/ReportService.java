package lv.tsi.hoteldbfx.service;

import lv.tsi.hoteldbfx.domain.Bill;
import lv.tsi.hoteldbfx.domain.BillRepository;
import lv.tsi.hoteldbfx.domain.Client;
import lv.tsi.hoteldbfx.domain.ClientRepository;
import lv.tsi.hoteldbfx.domain.Reservation;
import lv.tsi.hoteldbfx.domain.ReservationRepository;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {
    private final ClientRepository clientRepository;
    private final ReservationRepository reservationRepository;
    private final BillRepository billRepository;

    @Autowired
    public ReportService(ClientRepository clientRepository, ReservationRepository reservationRepository, BillRepository billRepository) {
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
        this.billRepository = billRepository;
    }

    public void createReport(long clientId) {
        Client client = clientRepository.findClientById(clientId);

        Element root = new Element("CLIENT");

        root.addContent(new Element("ID").addContent(String.valueOf(client.getId())));
        root.addContent(new Element("NAME").addContent(client.getName()));
        root.addContent(new Element("SURNAME").addContent(client.getSurname()));
        root.addContent(new Element("PERSONAL_CODE").addContent(String.valueOf(client.getProfile().getPersonalCode())));
        root.addContent(fillReservations(client));

        //Define root element like root
        Document doc = new Document();
        doc.setRootElement(root);

        //Create the XML
        XMLOutputter outter = new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        try {
            String reportName = "report_" + client.getProfile().getPersonalCode()
                    + "_" + client.getName()
                    + "_" + client.getSurname();
            outter.output(doc, new FileWriter("reports/" + reportName + ".xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Element fillReservations(Client client) {
        List<Reservation> reservations = reservationRepository.findAllByClient(client);
        Element reservationsElement = new Element("RESERVATIONS");

        for (Reservation reservation : reservations) {
            Element reservationElement = new Element("RESERVATION");
            reservationElement.addContent(new Element("ID").addContent(String.valueOf(reservation.getId())));
            reservationElement.addContent(new Element("CHECK_IN").addContent(reservation.getCheckIn().toString()));
            reservationElement.addContent(new Element("CHECK_OUT").addContent(reservation.getCheckOut().toString()));

            Bill bill = billRepository.findBillByReservation(reservation);

            if (bill != null) {
                Element billElement = new Element("BILL");
                billElement.addContent(new Element("ID").addContent(String.valueOf(bill.getId())));
                billElement.addContent(new Element("WORKER").addContent(bill.getWorker().toString()));
                billElement.addContent(new Element("DATE").addContent(bill.getDate().toString()));
                billElement.addContent(new Element("PRICE").addContent(String.valueOf(bill.getPrice())));

                reservationElement.addContent(billElement);
            }


            reservationsElement.addContent(reservationElement);
        }


        return reservationsElement;
    }
}
