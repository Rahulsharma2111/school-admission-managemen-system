package downloadStudentDetailsPackage;

import java.io.File;
import java.io.FileWriter;
//import schoolFormPackage.admission_database.*;
public class downloadStudentDetails {
    public void studownloadForm(int formNumDold) throws Exception{

        int FormNumber=formNumDold;
        // create file
        File f=new File("C:\\Users\\7475\\Desktop\\student_FormNumber.txt");
        try {
            schoolFormPackage.admission_database ad=new schoolFormPackage.admission_database();
            if (f.createNewFile()){
                FileWriter w=new FileWriter("C:\\Users\\7475\\Desktop\\student_FormNumber.txt");
                w.write("form no is : "+formNumDold );
              String[] stuData=  ad.fetchStudentDataFromDownloadFile(FormNumber);

                w.write("    Student name : "+stuData[0]);
                w.write("    Father's name : "+stuData[1]);
                w.write("    Mother's name : "+stuData[2] );
                w.write("    Mobile number : "+stuData[3] );
                w.write("    Email : "+stuData[4] );
                w.write("    Gender : "+stuData[5] );
                w.write("    Caste : "+stuData[6] );
                w.write("    Address : "+stuData[7] );
                w.write("    Pincode : "+stuData[8] );
                w.write("    Aadhar number : "+stuData[9] );
                w.write("    Admission class : "+stuData[10] );
                w.write("    Bus facility : "+stuData[11]);
                w.write("    Previous class : "+stuData[12] );
                w.write("    Previous class Percentage : "+stuData[13] );

                w.write("    Previous School name : "+stuData[14]);
//                w.append();
                w.append("sd" +
                        "sdf" +
                        "adsf" +
                        "sdf"
                );

                System.out.println("-______------______++++++ file create successfully -______------______++++++");
                w.close();
            }else {
                System.out.println("something is going wrong");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        // rename file
//        File fo=new File("C:\\Users\\7475\\Desktop\\student_FormNumber.txt");
//        File fn=new File("C:\\Users\\7475\\Desktop\\student_FormNumber.pdf");
//        fo.renameTo(fn);
    }

}
