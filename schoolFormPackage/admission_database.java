package schoolFormPackage;

import java.sql.*;
import java.util.Scanner;

public class admission_database {

    public Connection dbConntion()throws Exception{
        Connection connection = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_data", "root",
                    "rahul123");

            // Perform database operations
//            System.out.println("connection successfully");
//            // Close the connection
//            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int fetchFormNumber() throws Exception{
        Connection con= dbConntion();           //where stu_name='rahul shram'
        PreparedStatement ps =con.prepareStatement("select form_no from studentdatabase  ");
        ResultSet rs=ps.executeQuery();
        int formNumber=0;
        while (rs.next()){
             formNumber=rs.getInt("form_no");
//            System.out.println(formNumber);

        }

        con.close();
        return formNumber;
    }
    public void insertDataIntoDatabase( String stu_name, String fathers_name,
      String mothers_name, long mobile_number, String email_id, String gender, String caste,
      String address, long pincode, long addhar_no, int adm_class, String bus_facility,
      int previous_class, float pre_class_percentage, String pre_school_name) throws Exception {
       Connection con= dbConntion();
        PreparedStatement ps =con.prepareStatement("insert into studentDatabase values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        int form_no=fetchFormNumber()+1;
        ps.setInt(1,form_no);
        ps.setString(2,stu_name);
        ps.setString(3,fathers_name);
        ps.setString(4,mothers_name);
        ps.setLong(5,mobile_number);
        ps.setString(6,email_id);
        ps.setString(7,gender);
        ps.setString(8,caste);
        ps.setString(9,address);
        ps.setLong(10,pincode);
        ps.setLong(11,addhar_no);
        ps.setInt(12,adm_class);
        String bus=bus_facility.toLowerCase();
        ps.setString(13,bus); //bus_facility
        ps.setInt(14,previous_class);
        ps.setFloat(15,pre_class_percentage);
        ps.setString(16,pre_school_name);
//        ps.setString(15,);

        int i= ps.executeUpdate();
        if (i>0){
            System.out.println("Success");
        }else {
            System.out.println("Failed");
        }
        con.close();
    }

    public void fetchStudentDataFromDatabase(int formNum)throws Exception{
        Connection con= dbConntion();
        PreparedStatement ps =con.prepareStatement("select * from studentdatabase where form_no=? ");
        ps.setInt(1,formNum);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
//            String name=rs.getString("stu_name");

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

        }
        con.close();
    }

    public void updateStudentData(int formNumUpdate) throws Exception{
        Scanner sc_admissionDb=new Scanner(System.in);
        int choice=0;
        Connection con= dbConntion();
        PreparedStatement ps=null;
        int rs=0;
        do {
            System.out.println("Update menu select one option");
            System.out.println();
            System.out.println("   1. Student name ");
            System.out.println("   2. Father's name ");
            System.out.println("   3. Mother's name ");
            System.out.println("   4. Mobile number ");
            System.out.println("   5. Email ");
            System.out.println("   6. Gender ");
            System.out.println("   7. Caste ");
            System.out.println("   8. Address ");
            System.out.println("   9. Pincode ");
            System.out.println("   10. Aadhar number ");
            System.out.println("   11. Admission class ");
            System.out.println("   12. Bus facility ");
            System.out.println("   13. Previous class ");
            System.out.println("   14. Previous class Percentage ");
            System.out.println("   15. Previous School name ");
            System.out.println("   16. -- Exist -- "); System.out.println();
            System.out.print(" Select One Option in the given menu : ");
            choice= sc_admissionDb.nextInt();
            sc_admissionDb.nextLine();
            System.out.println();


            switch (choice){
                case 1:
                    System.out.print("Enter new name : ");
                    String name=sc_admissionDb.nextLine();
                     ps =con.prepareStatement("UPDATE studentdatabase SET stu_name=? where form_no=? ");
                    ps.setString(1,name);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 2:
                    System.out.print("Enter Father's name : ");
                    String fname=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET fathers_name=? where form_no=? ");
                    ps.setString(1,fname);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 3:
                    System.out.print("Enter Mother's name : ");
                    String mname=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET mothers_name=? where form_no=? ");
                    ps.setString(1,mname);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 4:
                    System.out.print("Enter Mobile Number : ");
                    long mobile=sc_admissionDb.nextLong();
                    ps =con.prepareStatement("UPDATE studentdatabase SET mobile_number=? where form_no=? ");
                    ps.setLong(1,mobile);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 5:
                    System.out.print("Enter Email ID : ");
                    String email=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET email_id=? where form_no=? ");
                    ps.setString(1,email);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 6:
                    System.out.print("Enter Gender : ");
                    String gender=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET gender=? where form_no=? ");
                    ps.setString(1,gender);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 7:
                    System.out.print("Enter Caste : ");
                    String caste=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET caste=? where form_no=? ");
                    ps.setString(1,caste);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 8:
                    System.out.print("Enter Address : ");
                    String address=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET address=? where form_no=? ");
                    ps.setString(1,address);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate(); if (rs>0){
                    System.out.println("Data Update successfully");
                }else {
                    System.out.println("Data did not Update ");
                }

                    break;

                case 9:
                    System.out.print("Enter Pincode : ");
                    long pincode=sc_admissionDb.nextLong();
                    ps =con.prepareStatement("UPDATE studentdatabase SET pincode=? where form_no=? ");
                    ps.setLong(1,pincode);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 10:
                    System.out.print("Enter Aadhar Number : ");
                    long aadhar=sc_admissionDb.nextLong();
                    ps =con.prepareStatement("UPDATE studentdatabase SET addhar_no=? where form_no=? ");
                    ps.setLong(1,aadhar);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 11:
                    System.out.print("Enter Addmission class : ");
                    int adClass=sc_admissionDb.nextInt();
                    ps =con.prepareStatement("UPDATE studentdatabase SET adm_class=? where form_no=? ");
                    ps.setInt(1,adClass);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 12:
                    System.out.print("Enter Bus Facility : ");
                    String bus=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET bus_facility=? where form_no=? ");
                    ps.setString(1,bus);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 13:
                    System.out.print("Enter Previous Class : ");
                    int pre_class=sc_admissionDb.nextInt();
                    ps =con.prepareStatement("UPDATE studentdatabase SET mothers_name=? where form_no=? ");
                    ps.setInt(1,pre_class);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 14:
                    System.out.print("Enter Previous Class Percentage : ");
                    float per=sc_admissionDb.nextFloat();
                    ps =con.prepareStatement("UPDATE studentdatabase SET pre_class_percentage=? where form_no=? ");
                    ps.setFloat(1,per);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 15:
                    System.out.print("Enter Previous School Name : ");
                    String school=sc_admissionDb.nextLine();
                    ps =con.prepareStatement("UPDATE studentdatabase SET pre_school_name=? where form_no=? ");
                    ps.setString(1,school);
                    ps.setInt(2,formNumUpdate);
                    rs=ps.executeUpdate();
                    if (rs>0){
                        System.out.println("Data Update successfully");
                    }else {
                        System.out.println("Data did not Update ");
                    }
                    break;

                case 16:
                    System.out.println();
                    System.out.println(" Thanks 🙂🙂🙂🙂");
                    System.out.println();
                default:
                    System.out.println(" Select Correct Option");
                    break;
            }

        }while (choice!=16);


        if (rs>0){
            System.out.println("Data Update successfully");
        }else {
            System.out.println("Data did not Update ");
        }
        con.close();
    }

    public String[] fetchStudentDataFromDownloadFile(int formNum)throws Exception{
        Connection con= dbConntion();
        PreparedStatement ps =con.prepareStatement("select * from studentdatabase where form_no=? ");
        ps.setInt(1,formNum);
        ResultSet rs=ps.executeQuery();
        String[] stuData=new String[15];
        while (rs.next()){

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

            stuData[0]=name;
            stuData[1] =fName;
            stuData[2] =mName;
            stuData[3] =mobileNumber+"";
            stuData[4] =emailId;
            stuData[5] =gender;
            stuData[6] =caste;
            stuData[7] =address;
            stuData[8] =pincode+"";
            stuData[9] =aadharNum+"";
            stuData[10] =currClass+"";
            stuData[11] =bus;
            stuData[12] =preClass+"";
            stuData[13] =percentage+"%";
            stuData[14] =schoolName;

        }
        con.close();
        return stuData;
    }

//    public static void main(String[] args)throws Exception {
//        schoolFrom.admission_database s=new schoolFrom.admission_database();
//        System.out.println(s.fetchFormNumber());
//    }

}

