package schoolFormPackage;

import java.sql.SQLOutput;
import java.util.Scanner;

import AdminPanelPackage.AdminDetails;
import downloadStudentDetailsPackage.downloadStudentDetails;
import AdminPanelPackage.Admin;

class InvalidString extends Exception{

    public void traverseStringForException(String studentdetail){
        try {

            for (int i = 0; i <studentdetail.length() ; i++) {
                char ch=studentdetail.charAt(i);
                int indexChar=(int)ch;
                if(indexChar>=65 && indexChar<=122){
                    throw new InvalidString();

                }
            }

        }catch (InvalidString e){
            System.out.println(e);
        }
    }
    @Override
    public String toString() {
      return " Enter only alphabets ";
    }
}

public class StudentAdmission {
    private static void studentAdmissionForm()  {
        //form number generated automatically
        // student name
        // father's name
        // mother's name
        // mobile number
        // email id
        // gender
        // caste category
        // address
        // addhar number
        // you admission in which class take
        // bus facility
        //-----previous school details-----
        // previous class.
        // previous class percentage
        // previous school

        // -----fees of admission-----
        // form fees 450rs.
        // extra fees 300rs.

//        String name="Rahul sharma";
//        String fathers_name="123";
//        String mothers_name="456";
//        long mobile_number=9876541023l;
//        String email_Id="abc@gmail.com";
//        String gender="Male";
//        String caste="Genral";
//        String address="Genral 54sfdg  g  gj kjfdh fgjh ";
//        long addhar_no=123045698745l;
//        int class_curr=8;
//        boolean bus_facility=true;
//        //---------=================
//        int previous_class=7;
//        float pre_class_percentage=65.82f;
//        String pre_school_name="skdd aes school";
//
//        // admission fees
//        int form_fees=450;
//        int extra_fees=450;

//        ++++++++++++++ Student Admission Form ++++++++++++++

        System.out.println("++++++++++++++ Student Admission Form ++++++++++++++ ");
        System.out.println();
        admission_database add=new admission_database();
        int form_no=0;
        try {
             form_no=add.fetchFormNumber();
        }catch (Exception e){
            System.out.println(e);
//            return;
        }
        System.out.println("                Apna School                ");
        System.out.println("Form No. "+(form_no+1));
        Scanner sc_stuDetails=new Scanner(System.in);
        System.out.println("----------- Student Details ----------- ");

        InvalidString isString=new InvalidString();

        System.out.print(" Student name : ");
        String stu_name=sc_stuDetails.nextLine();
        isString.traverseStringForException(stu_name);
        System.out.print(" Father's name : ");
        String fathers_name=sc_stuDetails.nextLine();
        System.out.print(" Mother's name : ");
        String mothers_name=sc_stuDetails.nextLine();
        System.out.print(" Mobile number : ");
        long mobile_number=sc_stuDetails.nextLong();
        sc_stuDetails.nextLine();
        System.out.print(" Email id : ");
        String email_Id=sc_stuDetails.nextLine();
        System.out.print(" Gender : ");
        String gender=sc_stuDetails.nextLine();
        System.out.print(" Caste : ");
        String caste=sc_stuDetails.nextLine();
        System.out.print(" Address : ");
        String address=sc_stuDetails.nextLine();
        System.out.print(" Pincode : ");
        long pincode=sc_stuDetails.nextLong();
        sc_stuDetails.nextLine();
        System.out.print(" Addhar number : ");
        long addhar_no=sc_stuDetails.nextLong();
        sc_stuDetails.nextLine();
        System.out.print(" Admission class : ");
        int Adm_class=sc_stuDetails.nextInt();
        sc_stuDetails.nextLine();
        System.out.print(" Bus facility : ");
        String bus_facility=sc_stuDetails.nextLine();

        System.out.println();
        System.out.println("-----Previous School Details-----");
        System.out.println();
        System.out.print(" Previous class : ");
        int previous_class=sc_stuDetails.nextInt();
        sc_stuDetails.nextLine();
        System.out.print(" Previous class percentage : ");
        float pre_class_percentage=sc_stuDetails.nextFloat();
        sc_stuDetails.nextLine();
        System.out.print(" Previous school : ");
        String pre_school_name=sc_stuDetails.nextLine();

        System.out.println();
        System.out.println("----- admission Charges -----");
        System.out.println();
        System.out.println("form_fees=450");
        System.out.println("extra_fees=450");

        // function data insert into database
    try {
        stuDataInsertInDatabase(stu_name, fathers_name, mothers_name, mobile_number, email_Id,
                gender, caste, address, pincode, addhar_no, Adm_class, bus_facility,
                previous_class, pre_class_percentage, pre_school_name);
    }catch (Exception e){
        System.out.println(e);
    }

    }

    public static void stuDataInsertInDatabase(String stu_name, String fathers_name,
         String mothers_name, long mobile_number, String email_id, String gender, String caste,
         String address, long pincode, long addhar_no, int adm_class, String bus_facility,
         int previous_class, float pre_class_percentage, String pre_school_name) throws Exception {

        admission_database adDB=new admission_database();
        adDB.insertDataIntoDatabase(stu_name, fathers_name, mothers_name, mobile_number, email_id,
                gender, caste, address, pincode, addhar_no, adm_class, bus_facility,
                previous_class, pre_class_percentage, pre_school_name);
        }


//    private static void studentYearlyFees(){
//        // according class vise
//        // dance swinning sports
//        //if sutdent select bus -- bus charges according to km
//    }


    public static void main(String[] args) throws Exception {
        System.out.println("_______________ Apna School _______________");
        System.out.println();


        Scanner sc=new Scanner(System.in);

        int choice;
        do {
            System.out.println("---------------- School Menu to Select the Option ----------------");
            System.out.println(" 1. Admission Form ");
            System.out.println(" 2. Show Details ");
            System.out.println(" 3. Download Student From ");
            System.out.println(" 4. Update Student Details ");
            System.out.println(" 5. Admin login ");
            System.out.println(" 6. Forget Admin Username Or Password ");
            System.out.println(" 7. Exists ");
            System.out.println();
            System.out.print(" Select One Option in the given menu : ");
            choice= sc.nextInt();
            System.out.println();
            admission_database db=new admission_database();

            switch (choice){
                case 1:
                    studentAdmissionForm();
                    break;

                case 2:
                    System.out.print(" Enter form number : ");
                    int formNum=sc.nextInt();
                    db.fetchStudentDataFromDatabase(formNum);
                    break;

                case 3:
                    System.out.print(" Enter form number : ");
                    int formNumDold=sc.nextInt();
                    downloadStudentDetails dsd=new downloadStudentDetails();
                    dsd.studownloadForm(formNumDold);
                    break;

                case 4:
                    System.out.print(" Enter form number : ");
                    int formNumUpdate=sc.nextInt();
                    db.updateStudentData(formNumUpdate);
                    break;

                case 5:
                    System.out.println("Admin Panel");
                    System.out.print("Enter Username : ");
                    sc.nextLine();
                    String username=sc.nextLine();

                    System.out.print("Enter Password : ");
                    String password=sc.nextLine();
                    Admin admin=new Admin();
                    admin.accessCheck(username,password);
                    break;

                case 6:
                    System.out.println("Forget Admin Username And Password Panel");
                    System.out.println();
                    System.out.print("Enter School name for verification you are admin : ");
                    sc.nextLine();
                    String schoolName=sc.nextLine();
                    AdminDetails ad=new AdminDetails();
                   boolean isTrueOrFalse =ad.fecthAdminSchoolName(schoolName);
                    if (!isTrueOrFalse){
                        System.out.println("❗❗❗❗ Alert ❗❗❗❗");
                        System.out.println("You are not admin !!!");
                        return;

                    }else {
                        System.out.println("Menu for Update Username And Password");
                        System.out.println("  1. Update Username");
                        System.out.println("  2. Update Password");
                        System.out.println();
                        System.out.print("Enter option : ");
                        int update= sc.nextInt();
                        System.out.println();

                        if (update==1){
                            System.out.print("Enter New Username : ");
                            sc.nextLine();
                            String newUsername=sc.nextLine();
                            ad.UpdateAdminUsernameAndPassword(newUsername,null);
                        } else if (update==2) {
                            System.out.println("Enter New Password");
                            String newPassword=sc.nextLine();
                            ad.UpdateAdminUsernameAndPassword(null,newPassword);
                        }
                    }


                    break;


                case 7:
                    System.out.println("🙂🙂🙂🙂 Thanks for visiting us 🙂🙂🙂🙂");
                    break;

                default:
                    System.out.println("Select correct options");
                    break;

            }
        } while(choice!=7);




    }
}



// student details fetch from database
// database connect
//data insert into database
//make pdf for data for








//    create table studentDatabase(stu_name varchar(15), fathers_name varchar(15),
//        mothers_name varchar(15), mobile_number long, email_id varchar(15),
//        gender varchar(6), caste varchar(10), address varchar(255), pincode long,
//        addhar_no long, adm_class int, bus_facility varchar(4),
//        previous_class int, pre_class_percentage float, pre_school_name varchar(55));