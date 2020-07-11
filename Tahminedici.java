package proje;
public class tahminEdici {
 public int tahmin(int ogrSayisi,int[][] liste,int elemanSayisi){//öğrenci sayısı parametre olarak alınıp en son kaç
öğrenci varsa o sayı giriliyor
 int toplammin = 100;
 int enYakin= 1;// en az bir benzer kişi bulucağımız için 1,bu sayac birden fazla benzer kişi olma ihtimali için
 int benzerToplam=0;//birden fazla kişinin benzerliğinde ortalama hesabı için verdikleri puanın toplamı için sayaç
 int sonuc = 0; //benzerlik toplamı
 int birdenFazlaMinToplam =0; // birden fazla minimum değer bulduktan sonra eğer bu değerlerden farklı daha düşük min değer çıkarsa diye oluşturulan değer
 for(int i =0;i<ogrSayisi;i++){
 int toplam = 0;
 for(int j = 0;j<elemanSayisi-1;j++){//5. elamana kadar olan puanlamaları karşılaştıracağımız için(5. hariç) elemansayısı-1 yaptık
 int a1 = liste[ogrSayisi][j]; // ogrSayisi parametresi toplam öğrenci sayısı olduğu için bunu kullanarak listedeki
son öğrencinin verdiği puanları kullanıyoruz
 int a2 = liste[i][j];//son öğrenciye kadar olan öğrencilerin verdikleri puan
 int fark = a1-a2;
 if (fark<0){ //farkın mutlağını almak için
 fark *=(-1);
 }
 toplam+=fark;
 }
 if(toplam<toplammin){//en küçük farklı öğrenciyi bulmak için
 toplammin=toplam;
 sonuc = liste[i][elemanSayisi-1];
 benzerToplam=sonuc;
 }
 else if (toplam == toplammin){//minimum farkın birden fazla olma ihtimali için
 enYakin++;
 benzerToplam+=liste[i][elemanSayisi-1];
 birdenFazlaMinToplam = toplammin;
 }
 }
 if (enYakin>1 && birdenFazlaMinToplam==toplammin){
 sonuc = benzerToplam/enYakin;
 return sonuc;
 }
 else
 return sonuc;
 }
 }
