package queues.arraydeque;

import queues.Category;
import queues.Customer;
import queues.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;

public class HelpDesk {

    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category){
        enquiries.offer(new Enquiry(customer,category));
    }

    public void processAllEnquiries(){

        /*Enquiry enquiry;

        while((enquiry = enquiries.poll()) != null){
            final Enquiry enquiry = enquiries.remove();
            enquiry.getCustomer().reply("Advice");
        }*/

        while(!enquiries.isEmpty()){
            final Enquiry enquiry = enquiries.remove();
            enquiry.getCustomer().reply("Advice");
        }

    }

    public static void main(String args[]){
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processAllEnquiries();
    }
}