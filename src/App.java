import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();

        while (true) {
            System.out.println("===Selamat Datang di Perpustakaan====");
            System.out.println("Menu: ");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Tampilkan Daftar Buku Yang Tersedia");
            System.out.println("6. Tampilkan Informasi Anggota");
            System.out.println("7. Keluar");
            System.out.println("=====================================");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("=====================================");
                    System.out.print("Judul: ");
                    String judul = sc.nextLine();
                    System.out.print("Pengarang: ");
                    String pengarang = sc.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int tahunTerbit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.println("=========Jenis Buku=========");
                    System.out.println("1. Buku Fisik");
                    System.out.println("2. Buku Digital");
                    System.out.println("=====================================");

                    System.out.print("Pilih jenis buku: ");
                    int pilihJenisBuku = sc.nextInt();
                    sc.nextLine();

                    switch (pilihJenisBuku) {
                        case 1:
                            Buku buku = new Buku(judul, pengarang, tahunTerbit, isbn);
                            perpustakaan.tambahBuku(buku);
                            break;
                        case 2:
                            System.out.print("Link: ");
                            String link = sc.nextLine();
                            System.out.print("Ukuran File (MB): ");
                            int ukuranFile = sc.nextInt();
                            sc.nextLine();
                            BukuDigital bukuDigital = new BukuDigital(judul, pengarang, tahunTerbit, isbn, link,
                                    ukuranFile);
                            perpustakaan.tambahBuku(bukuDigital);
                            break;
                        default:
                            System.out.println("Pilih jenis buku 1 atau 2.");
                            System.out.println("=====================================");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("=====================================");
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Nomor Anggota: ");
                    int nomorAnggota = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = sc.nextLine();
                    Anggota anggota = new Anggota(nama, nomorAnggota, alamat);
                    perpustakaan.tambahAnggota(anggota);
                    break;

                case 3:
                    System.out.println("=====================================");
                    System.out.print("Nomor Anggota: ");
                    nomorAnggota = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ISBN Buku: ");
                    isbn = sc.nextLine();
                    perpustakaan.pinjamBuku(nomorAnggota, isbn);
                    break;

                case 4:
                    System.out.println("=====================================");
                    System.out.print("Nomor Anggota: ");
                    nomorAnggota = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ISBN Buku: ");
                    isbn = sc.nextLine();
                    perpustakaan.kembalikanBuku(nomorAnggota, isbn);
                    break;

                case 5:
                    perpustakaan.tampilkanDaftarBuku();
                    break;

                case 6:
                    System.out.println("=====================================");
                    System.out.print("Nomor Anggota: ");
                    nomorAnggota = sc.nextInt();
                    sc.nextLine();
                    System.out.println("=====================================");
                    boolean anggotaDitemukan = false;
                    for (Anggota a : perpustakaan.daftarAnggota) {
                        if (a.nomorAnggota == nomorAnggota) {
                            a.tampilkanInfoAnggota();
                            anggotaDitemukan = true;
                            break;
                        }
                    }
                    if (!anggotaDitemukan) {
                        System.out.println("Anggota tidak ditemukan.");
                        System.out.println("=====================================");
                    }
                    break;

                case 7:
                    System.out.println("Terima kasih telah menggunakan perpustakaan kami!");
                    System.out.println("=====================================");
                    sc.close();
                    return;

                default:
                    System.out.println("Silahkan pilih menu 1-7.");
                    System.out.println("=====================================");
                    break;
            }
        }
    }
}