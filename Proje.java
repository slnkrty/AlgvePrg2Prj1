package proje;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Proje {
 public static void main(String[] args)
 {
 try { //dosya bulunamaması halindeki hata için bütün sistem try catch içine kurulu
 Scanner satirTarayicisi = new Scanner (new File("bilgi.txt"));
 String b = satirTarayicisi.nextLine();
 Scanner c = new Scanner(b);//bu scanner sadece öğretim elemanı sayısı için text dosyasının ilk
sayısını okuyor

 c.useDelimiter(",");
 int ogretimUyesiSayisi;
 ogretimUyesiSayisi=c.nextInt();//c scannerı ile aldığımıız öğretim üyesi sayısını
ogretimUyesiSayisi değişkenine atadık
 int sayac = 0;//öğrenci sayısı için sayaç
 int textOgrenciSayac = 0;//text dosyasındaki öğrenci sayısını öğrenmek için olan sayaç,girdi
ile alınan öğrencilerin çıktısı için kullanılan for döngüsünde kullanmak için
 Ogrenci[] ogrenciListesi=new Ogrenci[200];//öğrenci classı tipinde 200lük öğrenci listesi
(max 200 olacağı için listeyi de 200 ile sınırladık)
 int[][] puanKayitListesi=new int[200][ogretimUyesiSayisi];//öğrencilerin öğretmenlerine
verdiği puanları tutması için oluşturduğumuz 2 boyutlu liste 1. index öğrenci sayısı 2. index
öğretim görevlisi sayısına eşit
 while(satirTarayicisi.hasNextLine()){
 String ogrenciBilgiSatiri = satirTarayicisi.nextLine();

String comma =",";//her elemanı ayrı alabilmek için tokenizer kullandık ve tokenımız ",".
 StringTokenizer hoppidik = new StringTokenizer(ogrenciBilgiSatiri,comma);

 String egitim = hoppidik.nextToken();

 if (egitim.equals("u")) {
 String numara = hoppidik.nextToken();
 String isim = hoppidik.nextToken();
 String soyisim = hoppidik.nextToken();
 String patika = hoppidik.nextToken();

 ogrenciListesi[sayac]=new UnderGraduate(numara,isim,soyisim,patika);
 String puanSatiri = satirTarayicisi.nextLine();
 StringTokenizer hoppidik2 = new StringTokenizer(puanSatiri,comma);//verilmiş puan
satırı için ayrı bir tokenizer oluşturduk

 for(int i = 0;i<ogretimUyesiSayisi;i++){

String a =hoppidik2.nextToken(); //okuduğum puan verisini int e çevirebilmek için önce string olarak kaydedip sonra scanner yardımıyla int olarak aldık
 Scanner sayiScanner =new Scanner(a);
 puanKayitListesi[sayac][i]=sayiScanner.nextInt();

 }
 }
 else if(egitim.equals("g")){ // undergraduate'te yaptığımız işlemlerin aynılarını burda da yaptık

 String numara = hoppidik.nextToken();
 String isim = hoppidik.nextToken();
 String soyisim = hoppidik.nextToken();
 String konu = hoppidik.nextToken();
 String advisor = hoppidik.nextToken();

 ogrenciListesi[sayac]=new Graduate(numara,isim,soyisim,konu,advisor);
 String puanSatiri = satirTarayicisi.nextLine();
 StringTokenizer hoppidik2 = new StringTokenizer(puanSatiri,comma);
 for(int i = 0;i<ogretimUyesiSayisi;i++){

 String a =hoppidik2.nextToken();
 Scanner sayiScanner =new Scanner(a);

 puanKayitListesi[sayac][i]=sayiScanner.nextInt();
 }
 }
 sayac++;
 textOgrenciSayac++;
 }
 satirTarayicisi.close();
 String check = "evet";//input alımı için olan while döngüsüne ilk giriş için burada tanımladık
 Scanner tarama =new Scanner(System.in);

while(check.equals("evet")){

 System.out.println("Öğrencinin adı: \r");
 String isim=tarama.nextLine();
 System.out.println("Öğrencinin soyadı: \r");
 String soyİsim=tarama.nextLine();
 System.out.println("Öğrencinin numarası: \r");

 String numara =tarama.nextLine();

 System.out.println("Öğrencinin eğitim durumu(u/g) : \r");
 String egitim =tarama.nextLine();
 if(egitim.equals("u")){ // "u" harfine eşitse undergraduate sınıfına ait
 System.out.println("Eğitim kurumunda izlediğiniz patikayı giriniz: \r");//yapay zeka girdisi için "Yapay zeka" şeklinde giriş olmalı
 String patika = tarama.nextLine();

 ogrenciListesi[sayac]=new UnderGraduate(numara,isim,soyİsim,patika);

 for(int i=0;i<ogretimUyesiSayisi-1;i++){

 System.out.println((i+1)+".öğretim üyesi için puanınızı giriniz: \r");
 int puan = tarama.nextInt();
 puanKayitListesi[sayac][i]=puan;
 tarama.nextLine();//nextInt() yaptıktan sonra oluşacak problemi çözmek için yazdık

 }
 tahminEdici a = new tahminEdici();
 puanKayitListesi[sayac][ogretimUyesiSayisi-1]=a.tahmin(sayac, puanKayitListesi, ogretimUyesiSayisi);

 }else if(egitim.equals("g")){//g ye eşitse graduate sınıfına ait

 System.out.println("Tez konunuzu giriniz: \r");

String tezKonusu = tarama.nextLine();
 System.out.println("Tez Danışman hocanınızın ismi ve soyismi: \r");
 String tezDanisman = tarama.nextLine();
 ogrenciListesi[sayac]=new Graduate(numara,isim,soyİsim,tezKonusu,tezDanisman);
 for(int i=0;i<ogretimUyesiSayisi-1;i++){
 System.out.println((i+1)+" .öğretim üyesi için puanınızı giriniz: \r");
 int puan = tarama.nextInt();
 puanKayitListesi[sayac][i]=puan;
 tarama.nextLine();//nextInt sonrası oluşan sorunu çözmek için
 }
 tahminEdici a = new tahminEdici(); //tahimEdici classını 5. öğretim üyesine verilen puanı
hesaplamak için kullandık
 puanKayitListesi[sayac][ogretimUyesiSayisi-1]=a.tahmin(sayac, puanKayitListesi,
ogretimUyesiSayisi);
 }
 sayac++; //burdaki öğrenci sayısı sayacını arttırma her inputu aldıktan sonra yapılmakta
 System.out.println("Başka Öğrenci kaldı mı(evet/hayır) : \r");// kaldıysa "evet" şeklinde yazılmalı
 check = tarama.nextLine();

}
 System.out.println("Girdisi yapılan öğrencilerin bilgileri: ");
 for(int i = textOgrenciSayac ;i<sayac;i++){ //input olarak alınan öğrencilerin bilgilerini burdaki 2 for
döngüsüyle yazdırdık
 System.out.println("\n" + (i+1)+". öğrenci ismi: "+ogrenciListesi[i].getName()+"
"+ogrenciListesi[i].getSurname()+" numarası: "+ogrenciListesi[i].getStudentID());
 }
 for(int j =0;j<ogretimUyesiSayisi;j++){ //input olarak alınan öğrencilerin verdiği puanlarla
hesaplanıcak ortalamalar için oluşturulan for döngüsü (8. çıktı)
 double textPuanToplam = 0;
 for(int i = textOgrenciSayac ;i<sayac;i++){
 textPuanToplam+=puanKayitListesi[i][j];
 }
 System.out.println((j+1)+". öğretim görevlisinin sadece girdisi yapılan öğrencilerin verdiği
puanlara göre puan ortalaması : "+textPuanToplam/(sayac-textOgrenciSayac));//8.çıktının devamı
 }
 for(int i =0;i<ogretimUyesiSayisi;i++) //bu for döngüsünde projede istenilen çıktıları elde edebilmek
için bütün girdiler bittikten sonra oluşturuldu
 {

double tumtoplam = 0; // tüm öğrencilerin bir hocaya verdiği toplam puan için sayaç
 double gtoplam = 0; // graduate sınıfındaki öğrencilerin bir hocaya verdiği toplam puan için
sayaç
 double ugtoplam= 0; // undergraduate sınıfındaki öğrencilerin bir hocaya verdiği toplam puan
için sayaç
 double ugYapayToplam = 0;//undergraduate sınıfında olan ve izlediği patika yapay zeka olan
öğrencilerin bir hocaya verdiği toplam puan için sayaç
 double yapaySayac = 0;// undergraduate sınıfında olan ve izlediği patika yapay zeka olan
öğrenci sayısı için sayaç
 double ugOgrSayac = 0;//undergraduate sınıfından olan öğrenciler için sayaç
 int gOgrSayac = 0;//graduate sınıfından olan öğrenciler için sayaç
 for(int j=0;j<sayac;j++){
 tumtoplam+=puanKayitListesi[j][i];//puan listesinin birinci indexi öğrenciler,ikinci indexi
öğretmenler için
 if (ogrenciListesi[j].getClass().equals(UnderGraduate.class)) {//getClass() metoduyla öğrenci
listesine kaydedilen objelerin nesne isimlerine bakıyoruz
 ugOgrSayac ++;
 if (ogrenciListesi[j].toString().equals("Yapay zeka") ||
ogrenciListesi[j].toString().equals("Yapay zeka ")){

ugYapayToplam += puanKayitListesi[j][i];
 yapaySayac ++;
 }
 ugtoplam += puanKayitListesi[j][i];
 }
 else if(ogrenciListesi[j].getClass().equals(Graduate.class)){
 gtoplam += puanKayitListesi[j][i];
 gOgrSayac++;
 }
 }
 System.out.println(i+1+". öğretim üyesine ait ortalama derecelendirme puanı: "+(tumtoplam/sayac));//1. çıktı
 System.out.println("Sadece lisans öğrencierinin verdiği puanların ortalaması: "+ ugtoplam/ugOgrSayac);//2.çıktı
 System.out.println("Sadece lisansüstü öğrencierinin verdiği puanların ortalaması: "+ gtoplam/gOgrSayac);//3.
çıktı
 System.out.println("Sadece lisans öğrencilerinden izlediği patika yapay zeka olan öğrencilerin verdiği puanların
ortalaması: "+ ugYapayToplam/yapaySayac);//4. çıktı
 for (int k=0; k<sayac;k++)
 {
 if (puanKayitListesi[k][i]<(tumtoplam/sayac) && ogrenciListesi[k].getClass().equals(UnderGraduate.class))
 {
 System.out.println("Hesaplanan ortalamadan ve az veren lisans eğitimi alan kişinin bilgilleri:\n"+"İsmi : "
 +ogrenciListesi[k].getName() +" Soy adı : "

Alg ve Prog II, 2018- 2019 Proje-1
Berkhan Yiğit-05170000033
Selen Çağla Kurtay-05180000022
Mehmet Akif Konur-05170000077
14
 +ogrenciListesi[k].getSurname()+" Numarası : "
 +ogrenciListesi[k].getStudentID());}
 else if (puanKayitListesi[k][i]<(tumtoplam/sayac) &&
ogrenciListesi[k].getClass().equals(Graduate.class)){
 System.out.println("Hesaplanan ortalamadan az veren lisansüstü eğitim alan kişinin
bilgileri :\n"+"İsmi : "
 +ogrenciListesi[k].getName()+"\n"+ "Soy adı : "
 +ogrenciListesi[k].getSurname()+"\n"+ "Numarası : "
 +ogrenciListesi[k].getStudentID());
 }
 }
 }
 } catch(FileNotFoundException e) {
 System.out.println("Dosya bulunamadı");
 }
 System.exit(0);
 }
}
