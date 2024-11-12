import java.util.ArrayList;
import java.util.List;

public class Anggota {
  private String nama;
  protected int nomorAnggota;
  private String alamat;
  protected List<Buku> daftarPinjaman = new ArrayList<>();

  protected Anggota(String nama, int nomorAnggota, String alamat) {
    this.nama = nama;
    this.nomorAnggota = nomorAnggota;
    this.alamat = alamat;
  }

  // Method ini menampilkan informasi anggota
  protected void tampilkanInfoAnggota() {
    System.out.println("====Informasi Anggota====");
    System.out.println("Nama: " + nama);
    System.out.println("Nomor Anggota: " + nomorAnggota);
    System.out.println("Alamat: " + alamat);
    System.out.println("Daftar Pinjaman: ");
    boolean pinjamanKosong = true;
    // Menampilkan daftar buku yang dipinjam
    for (Buku buku : daftarPinjaman) {
      // Menampilkan informasi buku yang dipinjam
      buku.tampilkanInfoBuku();
      pinjamanKosong = false;
    }
    // jika tidak ada buku yang dipinjam
    if (pinjamanKosong) {
      // akan menampilkan pesan berikut
      System.out.println("==========================");
      System.out.println("Tidak ada buku yang dipinjam.");
    }
    System.out.println("==========================");
  }
}
