package AdminPanelPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import schoolFormPackage.admission_database;
public class AdminDetails {
    admission_database ad=new admission_database();
    public void fetchAllStudentData()throws Exception{

        Connection con= ad.dbConntion();
        PreparedStatement ps =con.prepareStatement("select * from studentdatabase ");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
//            String name=rs.getString("stu_name");
            int form_no= rs.getInt("form_no");
            String name =rs.getString("stu_name");
            String  fName=rs.getString("fathers_name");
            String  mName=rs.getString("mothers_name");
            long mobileNumber =rs.getLong("mobile_number");
            String emailId=rs.getString("email_id");
            String gender=rs.getString("gender");
            String caste=rs.getString("caste");
            String address=rs.getString("address");
            long  pincode=rs.getLong("pincode");
            long  aadharNum=rs.getLong("addhar_no");
            int  currClass=rs.getInt("adm_class");
            String  bus=rs.getString("bus_facility");
            int  preClass=rs.getInt("previous_class");
            float  percentage=rs.getFloat("pre_class_percentage");
            String  schoolName=rs.getString("pre_school_name");

            System.out.println("    Student form number : "+form_no);
            System.out.println("    Student name : "+name);
            System.out.println("    Father's name : "+fName);
            System.out.println("    Mother's name : "+mName);
            System.out.println("    Mobile number : "+mobileNumber);
            System.out.println("    Email : "+emailId);
            System.out.println("    Gender : "+gender);
            System.out.println("    Caste : "+caste);
            System.out.println("    Address : "+address);
            System.out.println("    Pincode : "+pincode);
            System.out.println("    Aadhar number : "+aadharNum);
            System.out.println("    Admission class : "+currClass);
            System.out.println("    Bus facility : "+bus);
            System.out.println("    Previous class : "+preClass);
            System.out.println("    Previous class Percentage : "+percentage);
            System.out.println("    Previous School name : "+schoolName);
            System.out.println();
            System.out.println();
        }
        con.close();
    }

    public void fetchAllStudentDataWhereSamePincodeAndBus(int stuPincode,String stu_Bus_facility)throws Exception{
//        long pin=stuPincode;
        Connection con= ad.dbConntion();
        PreparedStatement ps = null;
        if (stuPincode==0){
            String bus=stu_Bus_facility.toLowerCase();
            ps =con.prepareStatement("select * from studentdatabase  where  bus_facility=? ");
            ps.setString(1,bus);
        }else if (stu_Bus_facility == null){
            ps =con.prepareStatement("select * from studentdatabase  where pincode=? ");
            ps.setInt(1,stuPincode);
        }else {
            System.out.println("Something is wrong");
        }

        ResultSet rs=ps.executeQuery();
        while (rs.next()){
//            String name=rs.getString("stu_name");
            int form_no= rs.getInt("form_no");
            String name =rs.getString("stu_name");
            String  fName=rs.getString("fathers_name");
            String  mName=rs.getString("mothers_name");
            long mobileNumber =rs.getLong("mobile_number");
            String emailId=rs.getString("email_id");
            String gender=rs.getString("gender");
            String caste=rs.getString("caste");
            String address=rs.getString("address");
            long  pincode=rs.getLong("pincode");
            long  aadharNum=rs.getLong("addhar_no");
            int  currClass=rs.getInt("adm_class");
            String  bus=rs.getString("bus_facility");
            int  preClass=rs.getInt("previous_class");
            float  percentage=rs.getFloat("pre_class_percentage");
            String  schoolName=rs.getString("pre_school_name");

            System.out.println("    Student form number : "+form_no);
            System.out.println("    Student name : "+name);
            System.out.println("    Father's name : "+fName);
            System.out.println("    Mother's name : "+mName);
            System.out.println("    Mobile number : "+mobileNumber);
            System.out.println("    Email : "+emailId);
            System.out.println("    Gender : "+gender);
            System.out.println("    Caste : "+caste);
            System.out.println("    Address : "+address);
            System.out.println("    Pincode : "+pincode);
            System.out.println("    Aadhar number : "+aadharNum);
            System.out.println("    Admission class : "+currClass);
            System.out.println("    Bus facility : "+bus);
            System.out.println("    Previous class : "+preClass);
            System.out.println("    Previous class Percentage : "+percentage);
            System.out.println("    Previous School name : "+schoolName);
            System.out.println();
            System.out.println();
        }
        con.close();
    }

    public void UpdateAdminUsernameAndPassword(String adminUsername,String adminPassword) throws Exception{
        Connection con= ad.dbConntion();
        PreparedStatement ps=null;
        if (adminUsername!=null){
            ps=con.prepareStatement("UPDATE admindatabase SET username=? where schoolName='Apna School' ");
            ps.setString(1,adminUsername);
        }else if (adminPassword!=null){
             ps =con.prepareStatement("UPDATE admindatabase SET password=? where schoolName='Apna School' ");
            ps.setString(1,adminPassword);
        }else {
            System.out.println("Something is wrong");
        }

        int rs=ps.executeUpdate();
        if (rs>0){
            System.out.println("Data Update successfully");
        }else {
            System.out.println("Data did not Update ");
        }
        con.close();
    }

    public String[] fecthAdminUsernameAndPassword() throws Exception{
        String[] admin=new String[2];
        Connection con= ad.dbConntion();
        PreparedStatement ps=con.prepareStatement("select * from admindatabase where schoolName='Apna School'");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){

            String username =rs.getString("username");
            String  password=rs.getString("password");

            admin[0]=username;
            admin[1]=password;
        }
        con.close();
        return admin;
    }

    public boolean fecthAdminSchoolName(String schoolName) throws Exception{
        Connection con= ad.dbConntion();
        PreparedStatement ps=con.prepareStatement("select schoolName from admindatabase ");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){

            String fetchSchoolName =rs.getString("schoolName");
            if (schoolName.equals(fetchSchoolName)){
                con.close();
                return true;
            }
        }
        con.close();
return false;
    }
}
