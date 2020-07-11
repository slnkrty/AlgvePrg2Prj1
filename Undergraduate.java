package proje;
public class UnderGraduate extends Ogrenci {
 private String track;
 public UnderGraduate(String studentID, String name, String surname,String track) {
 super(studentID, name, surname);
 this.track=track;
 }
 public UnderGraduate() {
 super();
 track ="---";
 }
 public UnderGraduate(UnderGraduate c) {
 super(c);
 track=c.track;
 }
 public String getTrack() {
 return track;
 }
 public void setTrack(String track) {
 this.track = track;
 }
 @Override
 public String toString() {
 return super.toString()+track;
 } }
