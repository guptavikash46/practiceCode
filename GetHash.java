import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GetHash {
    
    public static void main(String[] args) {

        LicenceInformation li = new LicenceInformation();
        li.setLicenceName("testNameLic");
        li.setLicenceType("DEV");
        li.setProduct("HERMES");
        CustomerInformation ci = new CustomerInformation();
        ci.setContractId("35hdgvjd");
        ci.setCustomer("VG");
        ci.setMainContact("LTC");
        Map<String, Boolean> hardwareLocks = new LinkedHashMap<>();
        hardwareLocks.put("test1", true);
        hardwareLocks.put("test24", false);
        SeatInformation seat1 = new SeatInformation();
        seat1.setEmail("testEmail");
        seat1.setSeatId("1");
        List<SeatInformation> seatList1 = new ArrayList<>();
        seatList1.add(seat1);

        JsonData jData = new JsonData();
        jData.setLicenceInformation(li);
        jData.setCustomerInformation(ci);
        jData.setHardwareLocks(hardwareLocks);
        jData.setSeatInformation(seatList1);
        System.out.println("previous hashcode: "+ jData.hashCode());

        //new hashcode
        LicenceInformation li2 = new LicenceInformation();
        li2.setLicenceName("testNameLic");
        li2.setLicenceType("DEV");
        li2.setProduct("HERMES");
        CustomerInformation ci2 = new CustomerInformation();
        ci2.setContractId("35hdgvjd");
        ci2.setCustomer("VG");
        ci2.setMainContact("LTC");
        Map<String, Boolean> hardwareLocks2 = new LinkedHashMap<>();
        hardwareLocks2.put("test1", true);
        hardwareLocks2.put("test24", false);
        SeatInformation seat2 = new SeatInformation();
        seat2.setEmail("testEmail");
        seat2.setSeatId("1");
        List<SeatInformation> seatList2 = new ArrayList<>();
        seatList2.add(seat2);

        JsonData jData2 = new JsonData();
        jData2.setLicenceInformation(li2);
        jData2.setCustomerInformation(ci2);
        jData2.setHardwareLocks(hardwareLocks2);
        jData2.setSeatInformation(seatList2);
        
        System.out.println("list 1 hashcode: "+seatList1.hashCode() +", list 2 hashcode: "+seatList2.hashCode());
        System.out.println("current hashcode: "+ jData2.hashCode());
    }
}

class JsonData {

    private LicenceInformation licenceInformation;
    private CustomerInformation customerInformation;
    private Map<String, Boolean> hardwareLocks;
    private List<SeatInformation> seatInformation;

    public LicenceInformation getLicenceInformation() {
      return licenceInformation;
   }
   
   public void setLicenceInformation(LicenceInformation licenceInformation) {
      this.licenceInformation = licenceInformation;
   }
   public CustomerInformation getCustomerInformation() {
      return customerInformation;
   }
   
   public void setCustomerInformation(CustomerInformation customerInformation) {
      this.customerInformation = customerInformation;
   }
   public Map<String, Boolean> getHardwareLocks() {
      return new LinkedHashMap<>(hardwareLocks);
   }
   
   public void setHardwareLocks(Map<String, Boolean> hardwareLocks) {
      this.hardwareLocks = new LinkedHashMap<>(hardwareLocks);
   }
   public List<SeatInformation> getSeatInformation() {
      return List.copyOf(seatInformation);
   }
   
   public void setSeatInformation(List<SeatInformation> seatInformation) {
      this.seatInformation = List.copyOf(seatInformation);
   }


   @Override
   public int hashCode() {
       return Objects.hash(licenceInformation.getLicenceType(), customerInformation.getContractId(), 
       hardwareLocks, seatInformation);
   }

}
class LicenceInformation {

        private String licenceName;
        private String product;
        private String licenceType;

        public String getLicenceName() {
      return licenceName;
   }
   
   public void setLicenceName(String licenceName) {
      this.licenceName = licenceName;
   }
   
   public String getProduct() {
      return product;
   }
   
   public void setProduct(String product) {
      this.product = product;
   }
   
   public String getLicenceType() {
      return licenceType;
   }
   
   public void setLicenceType(String licenceType) {
      this.licenceType = licenceType;
   }
}

/////
class CustomerInformation {
    private String customer;
    private String contractId;
    private String mainContact;

    public String getCustomer() {
      return customer;
   }
   
   public void setCustomer(String customer) {
      this.customer = customer;
   }
   
   public String getContractId() {
      return contractId;
   }
   
   public void setContractId(String contractId) {
      this.contractId = contractId;
   }
   
   public String getMainContact() {
      return mainContact;
   }
   
   public void setMainContact(String mainContact) {
      this.mainContact = mainContact;
   }
}

////
class SeatInformation {
    private String seatId;
    private String email;

    public String getSeatId() {
      return seatId;
   }
   
   public void setSeatId(String seatId) {
      this.seatId = seatId;
   }
   
   public String getEmail() {
      return email;
   }
   
   public void setEmail(String email) {
      this.email = email;
   }
   
   @Override
   public int hashCode() {
       // TODO Auto-generated method stub
       //return super.hashCode();
       return Objects.hash(this.email, this.seatId);
   }

   @Override
   public boolean equals(Object obj) {
    SeatInformation si = (SeatInformation) obj;
       if (obj == null) return false;
       if (si.getEmail().equals(this.email) && si.getSeatId().equals(this.seatId) ) {
        return true;
       }
       return false;
   }
}