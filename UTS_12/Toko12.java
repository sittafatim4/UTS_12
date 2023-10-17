import java.util.Scanner;

public class Toko12 { 
    public static void main(String[] args) {
        Scanner sc12 = new Scanner(System.in);
        System.out.println("Program Toko");
        System.out.print("Masukkan nama Anda: ");
        String nama = sc12.nextLine();

        boolean Member = false;
        double totalhargasebelumdiskon = 0;
        double totalDiskon = 0;
        int jumlah = 0;

        while (true) {

            System.out.print("Masukkan nama produk yang Anda beli: ");
            String namaProduk = sc12.next();
            System.out.print("Banyaknya: ");
            int kuantitas = sc12.nextInt();
            System.out.print("Harga: ");
            double hargaSatuan = sc12.nextDouble();
            System.out.print("Diskon (%): ");
            String adaDiskon = sc12.next();
            double diskon = 0;

            if (adaDiskon.equalsIgnoreCase("Y")) {
                System.out.print("Masukkan persentase diskon: ");
                double persentaseDiskon = sc12.nextDouble();
                diskon = hargaSatuan * persentaseDiskon / 100;
            }

            double totalHargaProduk = (hargaSatuan - diskon) * kuantitas;
            totalhargasebelumdiskon += totalHargaProduk;
            totalDiskon += diskon;
            jumlah += kuantitas;

            System.out.print("Apakah Anda ingin menambahkan produk lagi (Y/N)? ");
            String tambahProduk = sc12.next();
            if (!tambahProduk.equalsIgnoreCase("y")) {
             System.out.print("Apakah Anda member (Y/N)? ");
            String memberStatus = sc12.next();
            if (memberStatus.equalsIgnoreCase("Y")) {
                Member = true;
            }
                break;
            }
        }

        
        if (Member && totalhargasebelumdiskon >= 200000) {
            totalDiskon += 0.1 * totalhargasebelumdiskon;
        } else if (Member) {
            totalDiskon += 0.05 * totalhargasebelumdiskon;
        }


        double totalAkhir = totalhargasebelumdiskon - totalDiskon;

        System.out.println("----------Total Pembelian----------");
        System.out.println("Nama Pelanggan                  = " + nama);
        System.out.println("Tipe                            = " + (Member ? "Member" : "Bukan Member"));
        System.out.println("Total Item Barang yang dibeli   = " + jumlah);
        System.out.println("SubTotal                        = " + totalhargasebelumdiskon);
        System.out.println("Total Diskon                    = " + totalDiskon);
        System.out.println("Total yang harus dibayar        = " + totalAkhir);
    }
}