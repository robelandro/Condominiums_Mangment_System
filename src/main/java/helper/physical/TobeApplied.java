package helper.physical;

public interface TobeApplied {
    public boolean checkInResident(String firstName , String residentId);
    public boolean checkForPayment(String firstName , String residentId,String purpose);
}
