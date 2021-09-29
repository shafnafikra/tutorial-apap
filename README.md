# Tutorial APAP

## Authors

- **Fikra Shafna Rahmania Putri Setyawan** - _1906304175_ - _APAP-C_

---

## Tutorial 3

#### Pertanyaan 1: Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)

Jawaban: **@AllArgsConstructor** menghasilkan constructor untuk semua field pada class dengan satu parameter. Secara default, constructor yang akan dihasilkan menjadi publik.
**@NoArgsConstructor** akan menghasilkan no-args constructor yang akan menghasilkan pesan error jika constructor terseebut tidak dapat ditulis karena adanya final fields.
Dengan **@Getter** dan **@Setter** akan dengan mudah men-generate getter dan setter atribut. Dengan demikian, yang sebelumnya perlu membuat setter dan getter manual atau men-generate dari IDE yang tersedia, kini tidak perlu membuat setter dan getter, melaikan hanya perlu memanggil get dan set diikuti dengan penamaan atribut dengan camelCase yang sesuai.
**@Entity** adalah anotasi yang memiliki fungsi untuk mewakili data yang akan dapat disimpan di database. Setiap instance dati suatu entity mewakili baris dalam tabel.
**@Table** adalah anotasi yang berguna sebagai penentu nama table database yang nantinya digunakan sebagai pemetaan.

Referensi :
https://javabydeveloper.com/lombok-allargsconstructor-examples/
https://projectlombok.org/api/lombok/NoArgsConstructor.html

#### Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut?

Pada BioskopDB terdapat anotasi @Repository. @Repository memiliki kegunaan agar Class yang mengimplementassikan anotasi tersebut bisa melakukan seperti operasi CRUD pada database,seperti operasi penyimpanan, pengambilan, pencarian, pembaruan, dan penghapusan pada objek. findByNoBioskop pada Class tersebut berguna sebagai operasi pencarian yang akan melakukan pencarian berdasarkan noBioskop.

Jawaban:

#### Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn

Jawaban: @JoinTable menyimpan id dari kedua entity ke tabel yang terpisah, sedangkan @JoinColumn menyimpan id dari entity lain di column baru di tabel yang sama. Penggunaan @JoinColumn ketika entity memiliki direct relationship seperti foreign key antara dua entity. Sedangkan, penggunaan @JoinTable ketika kita ingin mengatur hubungan antara entity dengan table lain.

Referensi:

#### Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull

Jawaban:

#### Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

Jawaban: **FetchType.LAZY** berisi seluruh data java object yang telah di-fetch saat dibutuhkan atau saat memanggil datanya (LAZY). FetchType biasanya digunakan di relasi many-to-many atau one-to-many.

**CascadeType.All** berguna supaya segala perubahan yang ada pada suatu entity akan terjadi juga pada entity seluruh anaknya/child. Perubahan terjadi saat ada delete, update, dan lainnya.

**FetchType.EAGER** berisi seluruh data java objects yang telah di-fetch langsung. fetchtype ini akan melakukan fetch-nya diawal. Berbeda dengan tipe LAZY, tipe ini digunakan untuk relasi many-to-one atau one-to-one.

---

## Tutorial 2

#### Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yangterjadi? Jelaskan mengapa hal tersebut dapat terjadi

Jawaban: Jika link tersebut diakses akan memunculkan Whitelabel Error Page Service Error 500. Hal ini dikarenakan sudah ada perintah return "add-bioskop" pada controller. Controller merupakan file yang berfungsi untuk melakukan mapping dari request yang diinput, kemudian akan diminta untuk memanggil template html yang akan direturn. Sedangkan html "add-bioskop" belum dibuat, sehinnga hal ini akan menyebabkan error.

#### Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

Jawaban: Anotasi @Autowired pada Controller merupakan implementasi dari konsep **dependancy injection**. @Autowired dapat memasukkan dependensi objek secara implisit. Sehingga, @Autowired pada BioskopController tidak perlu dibuat constructor, setter, dan getter. Hal ini dikarenakan @Autowired otomatis mencari service yang mengimplementasikan interface BioskopService.

#### Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Jawaban: Jika link tersebut diakses akan memunculkan Whitelabel Error Page type=Bad Request status=400. Hal ini dikarenakan parameter **jumlah studio** tidak dicantumkan. Sedangkan seluruh atribut harus terisi dan tidak boleh null.

#### Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung,link apa yang harus diakses?

Jawaban:
Bioskop dengan nama Bioskop Maung bisa diakses melalui link:
http://localhost:8080/bioskop/add?idBioskop=2&namaBioskop=Bioskop%20Maung&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10

Untuk mengaksesnya bisa diakses di:
http://localhost:8080/bioskop/view?idBioskop=2

#### Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

Jawaban:
Contoh bioskop yang saya buat:
http://localhost:8080/bioskop/add?idBioskop=3&namaBioskop=Bioskop%20Shafna&alamat=Jalan%20Jalan%20Pachill&noTelepon=0804xxx&jumlahStudio=99

Screen shot hasil :
![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-2-21cineplux/ScreenShot/SS_no5_FikraShafna.jpg)

---

## Tutorial 1

### What I have learned today

Pada tutorial pertama hari ini saya belajar lagi membuat project dengan springboot setelah terakhir kali saya memakai spring boot tahun lalu di mata kuliah DDP2. Selain itu saya juga belajar banyak istilah-istilah baru seperti Issue Tracker, git merge, VCS, library, dependency, Maven, dan masih banyak lagi.

### Github

1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Saat terdapat masalah/issue baru, issue tracker dapat digunakan untuk mencatat issue dan membuat issue tersebut. Hal ini dapat memudahkan tracking masalah atau permintaan perubahan yang ada hingga masalah tersebut diselesaikan. Issu Tracker dapat membantu dalam menyelesaikan bug, enhancement, mentracking task dan masalah lainnya.

2. Apa perbedaan dari git merge dan git merge --squash?
   Git merge merupakan opsi untuk membuat merge commit dengan mempertahankan histori commit dengan persis, commit akan terhubung dengan commit lain yang dibuat di parent branch. Sedangkat, git merge squash merupakan salah satu pilihan command penggabungan pada git yang akan menghasilkan merge commit dengan satu parent. File-filenya akan digabungkan seperti git merge pada umumnya, namun commit metadata-nya diubah menjadi satu parent commit.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
   suatu aplikasi?

- Document History : Histori dokumen memberikan informasi informasi penting mengenai penulis dan tanggal pengeditan. Hal ini memberikan dampak bagi developer yang mengerjakan versi terbaru karena akan membantuk menyelesaikan maslaah dari versi sebelumnya.
- Branching and Merging : VCS bisa memudahkan anggota tim untuk mengerjakan dokumen yang sama secara bersamaan dengan independen tanpa memengaruhi kontribusi sesama kolaborator.
- Management Overview : VCS bisa memberikan perspektif yang komprehensif dari pengembangan proyek bagi manajemennya. Dengan VCS yang bisa mengetahui peulis, tujuan perubahan, timeline progress, akan membantu manajemen dalam mengidentifikasi masalah yang mungkin berasal sari anggota tim tertentu.

### Spring

4. Apa itu library & dependency?
   Library merupakan kumpulan kode yang telah ditulis sebelumnya yang dapat digunakan user untuk mengoptimalkan tugasnya. Contoh library bisa ditemui di Python seperti library numpy, pandas, dan matplotlib.
   Dependency merupakan sebutan saat suatu software bergantung pada software lainnya dan berlaku sebaliknya. Contoh dari dependency adalah programming libraries, online service, dan programming scripts.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   Maven merupakan project management tools yang didasarkan pada POM (Project Object Model). Maven digunakan untuk membangun project, dependency, dan documentation. Proyek yang dapat dibangun dan dikelola dengan maven adalah proyek yang berbasis Java. Penggunaan Maven juga mempermudah intergrasi project ke sumber control system seperti git atau subversion. Alternatif untuk penggunaan maven adalah CMake, GNU Make, Gradle, SCons, dan Meson.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
   framework?
   Selain digunakan untuk pengembangan web, spring framework juga biasanya biasanya digunakan untuk pengembangan aplikasi di kalangan perusahaan. Spring juga bisa digunakan untuk pengembangan berbagai aplikasi Java seperti web app, mobil app, dan desktop app.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
   menggunakan @RequestParam atau @PathVariable?
   @RequestParam digunakan untuk mendapatkan parameter permintaan dari URL atau disebut query parameters, Sedangkan @PathVariable mengekstrak value dari URL. @RequestParam berguna untuk aplikai web yang bersifat tradisional yang mana datanya diteruskan dalam parameter query sementara. @PathVariable berguna untuk layanan web dengan framwork RESTfun yang mana URL-nya berisi value.

### What I did not understand

(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)

- [ ] Spring Solutions
- [ ] Apa itu Interface Segregation Principle (ISP)?
- [ ] Apa itu Inversion of Control (IoC)?
- [ ] Kenapa APAP sulit?

### Referensi

- https://www.geeksforgeeks.org/introduction-apache-maven-build-automation-tool-java-projects/
- https://www.idtech.com/blog/what-are-libraries-in-coding
- https://coderslegacy.com/what-are-dependencies-in-programming/
- https://reqtest.com/requirements-blog/what-are-benefits-of-version-control/
- https://devblogs.microsoft.com/devops/squash-a-whole-new-way-to-merge-pull-requests/
- https://cloudfour.com/thinks/squashing-your-pull-requests/
- https://www.zendesk.com/blog/issue-tracker/
