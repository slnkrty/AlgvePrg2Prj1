package proje;
public class Ogrenci {
public String name,surname,studentID;
public Ogrenci(String studentID,String name,String surname){
 this.name= name;
 this.surname= surname;
 this.studentID=studentID; }
public Ogrenci(){
 name = "Boş";
 surname = "Boş";
 studentID ="0";
}
Ogrenci(Ogrenci c){ //copy constructor
 name =c.name;
 surname =c.surname;
 studentID= c.studentID; }
}
 public String getStudentID() {
 return studentID;
 }
 public void setStudentID(String studentID) {
 this.studentID = studentID;
 }
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 public String getSurname() {
 return surname;
 }
 public void setSurname(String surname) {
 this.surname = surname;
 }
 @Override
 public String toString() {
 return String.format("");
 } }
