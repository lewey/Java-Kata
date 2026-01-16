package queues.arraydeque;

import queues.Category;
import queues.Customer;
import queues.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class CategorisedHelpDesk {

    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category){
        enquiries.offer(new Enquiry(customer,category));
    }

    //pre Java 8 example of processing. A lot of duplication.

    /*public void processPrinterEnquiry(){
        final Enquiry enquiry = enquiries.peek();

        if(enquiry != null && enquiry.getCategory() == Category.PRINTER){
            enquiries.remove();
            enquiry.getCustomer().reply("Printer advice");
        }else{
            System.out.println("Not for Printer department");
        }
    }

    public void processGeneralEnquiry(){

        final Enquiry enquiry = enquiries.peek();

        if(enquiry != null && enquiry.getCategory() != Category.PRINTER){
            enquiries.remove();
            enquiry.getCustomer().reply("General advice");
        }else{
            System.out.println("Not for General department");
        }
    }*/


    public void processPrinterEnquiry(){
        processEnquiry(
                enq -> enq.getCategory() == Category.PRINTER,"Printer Advice","Not for printer department"
        );
    }

    public void processGeneralEnquiry(){
        processEnquiry(
                enq -> enq.getCategory() !=Category.PRINTER, "General Advice", "Not for general department"
        );
    }

    public void processEnquiry(final Predicate<Enquiry> predicate, final String advice, final String rejection){
        final Enquiry enquiry = enquiries.peek();

        if(enquiry != null && predicate.test(enquiry)){
            enquiries.remove();
            enquiry.getCustomer().reply(advice);
        }else{
            System.out.println(rejection);
        }
    }


    public static void main(String args[]){
        CategorisedHelpDesk helpDesk = new CategorisedHelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }
}