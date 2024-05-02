package AdminPanelPackage;

import java.util.Scanner;

public class Admin {
    AdminDetails ad=new AdminDetails();
   public void accessCheck(String username,String password) throws Exception {

       String[] adminUserAndPass=ad.fecthAdminUsernameAndPassword();
       String admin_username_db=adminUserAndPass[0];
       String admin_password_db=adminUserAndPass[1];
//       System.out.println(username+" : "+password);
        if (username.equals(admin_username_db) && password.equals(admin_password_db)){
            Scanner sc_admin=new Scanner(System.in);
            int choice=0;
            do {
                System.out.println("---------------- Admin Menu to Select the Option ----------------");
//                System.out.println(" 1. Admission Form ");
//                System.out.println(" 2. Show Details ");
                System.out.println(" 1. See all Students details ");
                System.out.println(" 2. See all Students details where same pincode ");
                System.out.println(" 3. See all Students details where Bus facility is Yes Or No ");
                System.out.println(" 4. Update Username OR Password ");
                System.out.println(" 5. Exists ");
                System.out.println();
                System.out.print(" Select One Option in the given menu : ");
                choice= sc_admin.nextInt();
                System.out.println();

//                AdminDetails ad=new AdminDetails();

                switch (choice){
                case 1:
                    try {
                        ad.fetchAllStudentData();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 2:
                    System.out.print("Enter student Picode : ");
                    int  stuPincode= sc_admin.nextInt();
                   sc_admin.nextLine();
                    try {
                        ad.fetchAllStudentDataWhereSamePincodeAndBus(stuPincode, null);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.print("Bus facility Yes OR NO : ");
                    sc_admin.nextLine();
                    String stu_Bus_facility= sc_admin.nextLine();

                    try {
                        ad.fetchAllStudentDataWhereSamePincodeAndBus(0, stu_Bus_facility);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                    case 4:
                        System.out.println("Menu for Update Username And Password");
                        System.out.println("  1. Update Username");
                        System.out.println("  2. Update Password");
                        System.out.println();
                        System.out.print("Enter option : ");
                        int update= sc_admin.nextInt();
//                        System.out.println();
                        if (update==1){
                            System.out.print("Enter New Username : ");
                            sc_admin.nextLine();
                            String newUsername=sc_admin.nextLine();
                           ad.UpdateAdminUsernameAndPassword(newUsername,null);
                        } else if (update==2) {
                            System.out.println("Enter New Password");
                            String newPassword=sc_admin.nextLine();
                            ad.UpdateAdminUsernameAndPassword(null,newPassword);
                        }
                    break;

                case 5:
                    System.out.println("🙂🙂🙂🙂 Thanks for visiting us 🙂🙂🙂🙂");
                    break;

                default:
                    System.out.println("Select correct options");
                    break;

            }
             }while (choice!=5);

        }else {
            System.out.println("Your access deny because of worng username or password");
        }
    }
}
