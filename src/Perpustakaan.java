import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {
  public List<Buku> daftarBuku = new ArrayList<>();
  public List<Anggota> daftarAnggota = new ArrayList<>();

  // Method ini digunakan untuk menambahkan buku ke dalam daftarBuku
  public void tambahBuku(Buku buku) {
    daftarBuku.add(buku);
  }

  // Method ini digunakan untuk menampilkan daftar buku yang tersedia
  public void tampilkanDaftarBuku() {
    System.out.println("======Daftar Buku yang Tersedia======");
    // Jika daftar buku kosong, maka akan menampilkan pesan berikut
    if (daftarBuku.isEmpty()) {
      System.out.println("Tidak ada buku yang tersedia.");
      System.out.println("=====================================");
      return;
    }
    // Menampilkan informasi buku yang tersedia
    for (Buku buku : daftarBuku) {
      if (buku.tersedia) {
        buku.tampilkanInfoBuku();
      }
    }
    System.out.println("=====================================");
  }

  // Method ini digunakan untuk menampilkan informasi anggota
  public void tambahAnggota(Anggota anggota) {
    daftarAnggota.add(anggota);
  }

  // Method ini digunakan untuk meminjam buku
  public void pinjamBuku(int nomorAnggota, String isbn) {
    System.out.println("=====================================");
    Buku bukuDipinjam = null;
    // Mencari buku berdasarkan ISBN
    for (Buku buku : daftarBuku) {
      // Jika ISBN buku sama dengan ISBN yang diinputkan
      if (buku.isbn.equals(isbn)) {
        // Maka data buku disimpan ke dalam variabel bukuDipinjam
        bukuDipinjam = buku;
        // Menghentikan perulangan
        break;
      }
    }

    // Jika variabel bukuDipinjam bernilai null, maka akan menampilkan pesan berikut
    if (bukuDipinjam == null) {
      System.out.println("Buku tidak ditemukan atau ISBN tidak valid.");
      System.out.println("=====================================");
      return;

      // Jika ada data di variabel bukuDipinjam, cek status buku
      // Jika buku tidak tersedia, maka akan menampilkan pesan berikut
    } else if (!bukuDipinjam.tersedia) {
      System.out.println("Buku sedang dipinjam.");
      System.out.println("=====================================");
      return;
    }

    // Mencari anggota berdasarkan nomor anggota
    for (Anggota anggota : daftarAnggota) {
      // Jika nomor anggota sama dengan nomor anggota yang diinputkan
      if (anggota.nomorAnggota == nomorAnggota) {
        // Menambahkan buku ke dalam daftar pinjaman anggota
        anggota.daftarPinjaman.add(bukuDipinjam);
        // Mengubah status buku menjadi false dan menampilkan pesan berikut
        bukuDipinjam.tersedia = false;
        System.out.println("Buku berhasil dipinjam.");
        System.out.println("=====================================");
        return;
      }
    }
    // Jika nomor anggota tidak ditemukan, maka akan menampilkan pesan berikut
    System.out.println("Anggota tidak ditemukan.");
    System.out.println("=====================================");
  }

  // Method ini digunakan untuk mengembalikan buku
  public void kembalikanBuku(int nomorAnggota, String isbn) {
    System.out.println("=====================================");
    Buku bukuDikembalikan = null;
    // Mencari buku berdasarkan ISBN yang diinputkan
    for (Buku buku : daftarBuku) {
      // Jika ISBN buku sama dengan ISBN yang diinputkan
      if (buku.isbn.equals(isbn)) {
        // Maka data buku disimpan ke dalam variabel bukuDikembalikan
        bukuDikembalikan = buku;
        // Menghentikan perulangan
        break;
      }
    }
    // Jika variabel bukuDikembalikan bernilai null, maka akan menampilkan pesan berikut
    if (bukuDikembalikan == null) {
      System.out.println("Buku tidak ditemukan atau ISBN tidak valid.");
      System.out.println("=====================================");
      return;
    }

    // Mencari anggota berdasarkan nomor anggota
    for (Anggota anggota : daftarAnggota) {
      // Jika nomor anggota sama dengan nomor anggota yang diinputkan
      if (anggota.nomorAnggota == nomorAnggota) {
        // Hapus buku dari daftar pinjaman anggota
        if (anggota.daftarPinjaman.remove(bukuDikembalikan)) {
          // Mengubah status buku menjadi true dan menampilkan pesan berikut
          bukuDikembalikan.tersedia = true;
          System.out.println("Buku berhasil dikembalikan.");
          System.out.println("=====================================");
          return;
          // Jika buku tidak ditemukan dalam daftar pinjaman anggota, maka akan menampilkan pesan berikut
        } else {
          System.out.println("Buku tidak ditemukan dalam daftar pinjaman anggota.");
          System.out.println("=====================================");
          return;
        }
      }
    }
    System.out.println("Anggota tidak ditemukan.");
    System.out.println("=====================================");
  }
}
