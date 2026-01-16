package queues.priorityqueue;

import queues.Category;
import queues.Customer;
import queues.Enquiry;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {

    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>(){
        public int compare(final Enquiry enquiry1, final Enquiry enquiry2){
            //enum compareTo is order based
            return enquiry1.getCategory().compareTo(enquiry2.getCategory());
        }
    };

    private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(final Customer customer, final Category category){
        enquiries.offer(new Enquiry(customer,category));
    }

    public void processAllEnquiries(){
        Enquiry enquiry;
        while((enquiry = enquiries.poll()) != null){
            enquiry.getCustomer().reply("General Advice");
        }
    }



    public static void main(String args[]){
        PriorityHelpDesk helpDesk = new PriorityHelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);
        helpDesk.enquire(Customer.MARY, Category.COMPUTER);

        helpDesk.processAllEnquiries();


    }
}