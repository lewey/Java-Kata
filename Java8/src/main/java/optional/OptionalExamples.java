package optional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/*
    The reason why Optional exist is so that you don't have to deal with null checking
    and the dreaded NullPointerException
 */
public class OptionalExamples {

    private String createNewString(int id){
        System.out.println("creating a new Sting: " + id);
        return "new string";
    }

    public static void main(String args[]){

        // SETTING AN OPTION
        Optional<String> empty = Optional.empty();  // similar to setting an Option to None in Scala
        Optional<String> nullOp = Optional.ofNullable(null);  // specifying that a value may be null
        Optional<String> nullSet = Optional.ofNullable("Hello"); // specifying that a value may be null but has a value set
        Optional<String> ofValue = Optional.of("world"); // specifying that a value must be set.

        //OBTAINING A VALUE FROM AN OPTION

        // .GET  should avoid
        try{
            empty.get();
        } catch(NoSuchElementException exception) {
           System.out.println("exception caught");
        }

        // use a safe guard which is still imperative based and should be avoided
        if(nullSet.isPresent()){
            System.out.println(nullSet.get());
        }else{
            System.out.println("No value set");
        }

        System.out.println(".get for nullable value which is set: " + nullSet.get());
        System.out.println(".get for value which is set: " + ofValue.get());

        // DEFAULT VALUES

        //OR ELSE
        String helloWorld = empty.orElse("Hello World"); // a bit like getOrElse in scala
        System.out.println(helloWorld); // Hello World

        //OR ELSE GET
        //Suppliers are great for lazy evaluation, they take no arguments
        String helloWorldSupplier = empty.orElseGet(() -> "Hello World"); // a supplier is used fo an alternative
        System.out.println(helloWorldSupplier); // Hello World

        // IF PRESENT
        //if present can take a consumer function
        nullSet.ifPresent(u -> System.out.println("u length: " + u.length()));

        // when there is no value the consumer will not run
        nullOp.ifPresent(u -> System.out.println(u.length()));

        //DIFFERENCE BETWEEN orElse() AND orElseGet()
        OptionalExamples oe = new OptionalExamples();

        // createNewString() is not lazy and will always be evaluated
        System.out.println("using or else");
        nullSet.orElse(oe.createNewString(1));

        // createNewString() is lazy and won't be evaluated as the orElse get is not invoked
        System.out.println("using orElseGet");
        nullSet.orElseGet(() -> oe.createNewString(2));


        // TRANSFORMING VALUES
        User user1 = oe.new User("John");
        Optional<User> nullUser = Optional.ofNullable(null);
        Optional<User> userSet = Optional.of(user1);
        Optional<User> emptyUser = Optional.empty();

        //MAP
        // is used to simply transform if a value exists
        String name = Optional.of(user1)
                .map(User::getName)
                .orElse("No name was set");

        System.out.println(name);

        //another example of transforming. No need to use Optional.xxx if we are already dealing with an Option
        String upperCaseName = userSet
                .map(user -> user.getName().toUpperCase())
                .orElseGet(() -> "Default name");

        System.out.println(upperCaseName);


        // map will be ignored if the Optional is empty
        String defaultName = emptyUser
                .map(user -> user.getName().toUpperCase())
                .orElseGet(() -> "Bob");

        System.out.println("The default name is:" + defaultName);

        //---------------------------------------------------------------------------

        //FLAT MAP
        // flat map requires that what be returned as part of the function is an Optional
        // if map were used here what would be returned would be an Optional<Optional<String>>
        String middleNameUppercase = Optional.of(user1)
                .flatMap(User::getMiddleName)
                .map(String::toUpperCase)
                .orElse("No middle name set");

        System.out.println(middleNameUppercase);

        String middleName = userSet
                .flatMap(user -> user.getMiddleName().map(String::toUpperCase))  // done on one line if preferred
                .orElse("No middle name set");

        System.out.println(middleName);

        //-------------------------------------

        //FILTERING VALUES

        Optional<User> onlyJohn = Optional.of(user1)
                .filter(u -> u.getName().equalsIgnoreCase("John"));

        onlyJohn.ifPresent(user -> System.out.println(user.getName()));

        //--------------------------------------

        //CHAINING
        UserAllNull userChain = oe.new UserAllNull();

        String countryCode = Optional.of(userChain)
                .flatMap(UserAllNull::getAddress)
                .flatMap(Address::getCountry)
                .flatMap(Country::getCountryCode)
                .orElse("Default");


        System.out.println("country code is: " + countryCode);

        UserConstructor userConstructor = oe.new UserConstructor(Optional.ofNullable(null));

        String countryCodeConstructor = Optional.of(userConstructor)
                .flatMap(UserConstructor::getAddress)
                .flatMap(AddressConstructor::getCountry)
                .flatMap(CountryConstructor::getCountryCode)
                .orElse("Default");


        System.out.println("country code is: " + countryCodeConstructor);

    }


    //--------------------------------------

    public class User{
        private final String name;
        private final Optional<String> middleName; //Optional may not be Serializable so be careful

        public User(String name){
            this.name  = name;
            this.middleName = Optional.empty();
        }

        public String getName() {
            return this.name;
        }

        public Optional<String> getMiddleName(){
            return this.middleName;
        }
    }

    //-----------------------------------------

    // classes missing constructor to enforce nulls for this example. Only the return types specify the optionality
    public class UserAllNull {
        private Address address;

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }
    }

    public class Address{
        private Country country;

        public Optional<Country> getCountry() {
            return Optional.ofNullable(country);
        }
    }

    public class Country{
        private String countryCode;

        public Optional<String> getCountryCode(){
            return Optional.ofNullable(countryCode);
        }
    }

    //-------------------------------------------------


    public class UserConstructor {
        private Optional<AddressConstructor> address;

        public UserConstructor(Optional<AddressConstructor> address){
            this.address = address;
        }

        public Optional<AddressConstructor> getAddress() {
            return address;
        }
    }

    public class AddressConstructor {
        private Optional<CountryConstructor> country;

        public AddressConstructor(Optional<CountryConstructor> country){
            this.country = country;
        }

        public Optional<CountryConstructor> getCountry() {
            return country;
        }
    }

    public class CountryConstructor {
        private Optional<String> countryCode;

        public CountryConstructor(Optional<String> countryCode){
            this.countryCode = countryCode;
        }

        public Optional<String> getCountryCode(){
            return countryCode;
        }
    }

    //-----------------------------------

}
