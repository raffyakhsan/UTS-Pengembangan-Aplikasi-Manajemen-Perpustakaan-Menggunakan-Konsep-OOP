public class BukuDigital extends Buku {
  private String link;
  private int ukuranFile;

  // Constructor dari class BukuDigital
  public BukuDigital(String judul, String pengarang, int tahunTerbit, String isbn, String link, int ukuranFile) {
    super(judul, pengarang, tahunTerbit, isbn);
    this.link = link;
    this.ukuranFile = ukuranFile;
  }

  // Method ini menampilkan informasi buku digital
  @Override
  protected void tampilkanInfoBuku() {
    super.tampilkanInfoBuku();
    System.out.println("Link: " + link);
    System.out.println("Ukuran File: " + ukuranFile + " MB");
    System.out.println("======================");
  }
  
}
