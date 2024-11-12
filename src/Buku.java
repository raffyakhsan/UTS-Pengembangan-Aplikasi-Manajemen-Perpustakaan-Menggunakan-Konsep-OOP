public class Buku {
  private String judul;
  private String pengarang;
  private int tahunTerbit;
  public String isbn;
  public boolean tersedia;

  // Ini constructor dari class Buku
  public Buku(String judul, String pengarang, int tahunTerbit, String isbn) {
    this.judul = judul;
    this.pengarang = pengarang;
    this.tahunTerbit = tahunTerbit;
    this.isbn = isbn;
    this.tersedia = true;
  }

  // Method ini menampilkan informasi buku
  protected void tampilkanInfoBuku() {
    System.out.println("====Informasi Buku====");
    System.out.println("Judul: " + judul);
    System.out.println("Pengarang: " + pengarang);
    System.out.println("Tahun Terbit: " + tahunTerbit);
    System.out.println("ISBN: " + isbn);
    // Menampilkan status buku menggunakan operator ternary,
    // jika tersedia bernilai true, maka statusnya "Tersedia",
    // jika tidak maka statusnya "Dipinjam"
    System.out.println("Status: " + (tersedia ? "Tersedia" : "Dipinjam"));
    System.out.println("======================");
  }
}
