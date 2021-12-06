# Tutorial APAP

## Authors

- **Fikra Shafna Rahmania Putri Setyawan** - _1906304175_ - _APAP-C_

---

# Tutorial 8

### Pertanyaan 1: Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?

pada latihan nomor 1 diminta untuk solve masalah dimana saat kembali menekan tombol "Add New Item" masih terdapat value dari item sebelumnya. Hal ini bisa terjadi karena statenya masih berissi value item sebelumnya. Sehingga, pada latihan ini, saya mengosongkan statenya kembali, kemudian melakukan this.loadData(). Dengan demikian, saat membuka modal tersebut nantinya form fieldnya kosong.
Berikut code untuk langkah-langkah tersebut.

```
this.setState({
   title: "",
   price: 0,
   description: "",
   category: "",
   quantity: 0
})

```

### Pertanyaan 2: Jelaskan fungsi dari async dan await!

- _async_ berarti asynchronous, async merupakan sebuah fungsi yang bertujuan untuk mengatasi permasalahan asynchronous yang ada di Javascript. Async akan otomatis mengembalikan return value berupa obek dengan tipe Promise, dengan kondisi lain dapat jufa ditolak dengan uncaught error dan bisa menggunakan 'await'
- _await_ berfungsi untuk program dapat mengetahui untuk keluar secara sementara dari fungsi async baru kemuduan melanjutkan programnya saat task telah selesai.

### Pertanyaan 3: Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle pada pertanyaan ini.

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/1.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/2.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/3.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/4.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/5.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/6.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/7.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/8.jpeg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-8-frontend/ScreenShot/tutorial-8/9.jpeg)

### Pertanyaan 4: Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.

- _componentDidMount_ : sebuah komponen Lifecycle yang digunakan untuk mengambil data. Selain itu juga digunakan untuk menandakan akhir dari tahapan mounting lifecycle. Dipanggil setelah render HTML selesai loading. Fungsi ini dapat dipakai untuk memngambil data dari API website lain, kemudian di-render.
- _shouldComponentUpdate_ : sebuah komponen Lifecycle yang digunakan dalam menentukan perubahan yang terjadi di component apakah akan ditampilkan atau tidak. Fungsi ini dijalankan setelah state component menalami perubahan dan sebelum rendering. Contoh penggunaannya pada saat ingin mengubah komponen dan rendering setiap ada perubahan state.
- _componentDidUpdate_ : Digunakan saat melakukan interaksi dengan browser atau API. Dijalankan pada saat rendering HTML selesai melakukan loading dan satu instance dalam komponen melakukan update. Contoh penggunaannya saat update suatu komponen, seperti pada saat mengupdate jumlah quantity yang dimiliki oleh item barang.
- _componentWillReceiveProps_ : Dapat melakukan perubahan state berdasarkan dengan props saat ini dan props yang baru. Dijalankan ketika terjadi perubahan pada props sebelum component di-render dan dipanggul saat komponen akan menerima props. Contoh penggunaanya saat ingin melakukan reset state.
- _componentWillUnmount_ : dapat melakukan pembersihan timer yang tidak valid, membatalkan permintaan jaringan, dan pembatalan permintaan jaringan saat terdapat action yang berkaitan dengan cleanup. Dijalankan saat ada component yang dihapus dari DOM. Contoh penggunaannya saat menghapus interval waktu fungsi berjalan.

---

# Tutorial 7

### Pertanyaan 1: Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.

- Nomor 1

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-7-frontend/ScreenShot/tutorial7_handledelete_awal.jpg)

Pada soal satu ini, saya membuat method hanleDeleteItemToCart. Secara garis besar, isi dari method ini sama dengan handleAddItemToCart. Namun, pada method ini, terdapat kondisi dimana targetInd lebih besar sama dengan 0 (nol), kemudian membuat value dari newItem.inCart menjadi false. Kemudian, memanggil method **splice** dengan parameter (targetInd, 1). Tidak lupa, saya memamnggil this.handleDeleteItemToCart pada button, agar dapat di-delete.

- Nomor 2

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-7-frontend/ScreenShot/tutorial7_in_dec_price.jpg)

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-7-frontend/ScreenShot/tutorial7_add_del.jpg)

Pertama, saya membuat method increaseBalance dan decreaseBalance yang nanti akan dipanggil di handleAddItemToCart dan handleDeleteItemFromCart

- Nomor 3

![alt text](https://github.com/shafnafikra/tutorial-apap/blob/feat/tutorial-7-frontend/ScreenShot/tutorial7_alert.jpg)

Untuk memunculkan alert balance tidak mencukupi, saya menambahkan memanggil method alert pada decreaseBalace.

### Pertanyaan 2: Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?

- props yang merupakan singkatan dari property adalah masukkan dari sebuah komponen. Nilai dari prop di-passing seperti atribut HTML dan bersifat read-only. Dengan demikian props biasanya digunakan untuk komunikasi antar component.
- state merupakan data private dati component. Data pada state tidak dapat diakses dari component lain atau hanya tersedia pada component tersebut. Jika dibandingkan dengan props, value pada props dilempar dari component lain, sedangkan state menyimpan dan mengubah data sendiri dari dalam coomponentnnya.

### Pertanyaan 3: Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.

Component pada react memiliki sifat yang _reusable_ yang dapat digunakan kembali. Dengan menggunakan component, penyusunan code akan jauh lebih mudah untuk dibaca. Sehingga, mudah untuk memperbaiki error. Dengan demikian, bisa dikatakan bahwa penggunaan component sebaiknya digunakan.

### Pertanyaan 4: Apa perbedaan class component dan functional component?

|                           Class Component                            |                                   Functional Component                                   |
| :------------------------------------------------------------------: | :--------------------------------------------------------------------------------------: |
| Component dan membuat fungsi render yang mengembalikan elemen React. | Sebuah fungsi JavaScript yang menerima props sebagai argument dan me-return elemen React |
|        harus memiliki metode render() yang mengembalikan HTML        |            Tidak ada metode render yang digunakan dalam komponen fungsional.             |
|            Menggunakan constructor untuk menyimpan status            |                              tidak menggunakan constructor.                              |

### Pertanyaan 5: Dalam react, apakah perbedaan component dan element?

|                                                                      Component                                                                      |                                                         Element                                                          |
| :-------------------------------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------: |
| Component adalah objek sederhana yang menggambarkan DOM node dan atribut atau propertinya. Component terdiri dari elemen dan memiliki fungsi render | Element adalah objek biasa yang menjelaskan apa yang akan ditampilkan dalam bentuk DOM . Elemen berisi tipe dan properti |

#### Referensi:

- https://www.mahirkoding.com/tutorial-react-perbedaan-state-dan-props/
- https://medium.com/coderupa/react-prop-state-apa-bedanya-7ee61df8257f
- https://www.geeksforgeeks.org/differences-between-functional-components-and-class-components-in-react/

---

## Tutorial 6

### Pertanyaan 1: Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?

Otentikasi adalah proses melakukan verifikasi apakah pengguna yang ingin melakukan login dengan username yang dimiliki terlah tersedia di database dan dapat masuk untuk mengakses aplikasi. Sedangkan, otorisasi adalah proses untuk menentukan hak pengguna apakah pengguna tersebut memiliki akses ke halaman tertentu yang telah ditentukan otentifikasinya.

Implementasi otentikasi pada class WebSecurityConfig

```
@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
```

Implementasi otorisasi pada class WebSecurityConfig

```
.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/user/add").hasAuthority("ADMIN")
                .antMatchers("/user/viewall").hasAuthority("ADMIN")
                .antMatchers("/user/delete").hasAuthority("ADMIN")
                .antMatchers("/penjaga/**").hasAuthority("MANAGER")
                .anyRequest().authenticated()
```

### Pertanyaan 2: Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.

BCryptPasswordEncoder merupakan sebuah class yang mengimplementasikan PasswordEncoder dan juga menyediakan password hashing. Untuk melakukan register password, tidak mngkin dengan menggunakan plaintext, maka penyimpanan password mengguakan hashing. BCryptPasswordEncoder bekerja dengan menyimpan password yang telah di-hashing terlebih dahulu.

### Pertanyaan 3: Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?

Encryption dan hashing merupakan dua istilah yang berbeda. Encryption adalah proses mengubah sebuah pesan normal (plaintext) menjadi pesan yang tidak mudah dibaca (ciphertext). Ciphertext yang diperoleh dari encryption dapat dengan mudah diubah menjadi plaintext menggunakan encryption key. Hashing adalah proses mengubah informasi menjadi kunci menggunakan hash function. Informasi asli tidak dapat diambil dari hash key dengan cara apapun. Dengan demikian, penyimpanan password akan lebih aman jika dilakukan dengan hashing daripada encryption.

### Pertanyaan 4: Jelaskan secara singkat apa itu UUID beserta penggunaannya!

UUID (Universally Unique Identifier) merupakan kode dengan jumlah hashing terbanyak yaitu sebanyak 32 karakter yang akan digunakan untuk keamanan data. UUID di-generate untuk id pengguna. Dibandingkan dengan BCrypt yang merupakan password yang berguna untuk mengamankan id dari hacking. Dapat dipastikan UUID yang tergenerate unik untuk tiap objek yang ada di internet, jadi id yang dimiliki pengguna akan aman.

### Pertanyaan 5: Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?

class UserDetailsServiceImpl.java memberikan informasi mengenai Otentikasi dan Otorisasi akun yang ada pada class lain. Class ini harus diimplementasikan, jika tidak informasi tersebut tidak dapat diberikan. Kemampuan tersebut ada karena class mengimplementasikan UserDetailService. UserDetailService merupakan interface yang ada dari Spring Security. Selain itu, class ini meng-override loadUserByUsername() yang bisa dilakukan kustomisasi untuk pencarian user.

---

## Tutorial 5

### Pertanyaan 1: Apa itu Postman? Apa kegunaannya?

Postman adalah sebuah developent tool API yang digunakan untuk build, modify, dan test API. Penggunaan Postman dapat digunakan untuk mendesign, mock, debug, tes, dokumentasi, monitor, dan juga menerbitkan API. Postman memiliki fungsi REST Client yang dapat digunakan untuk menguji REST API.

### Pertanyaan 2: Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.

@JsonIgnoreProperties digunnakan untuk memberikan spesifikasi list atribut dari sebuah class yang diabaikan saat menjalankan serialization dan deserialozation JSON. Jika @JsonIgnoreProperties tidak disertakan, nantinya akan menyebabkan error saat menjalankan serialization dan deserialization saat Java Object tidak memiliki field yang ada pada JSON.

### Pertanyaan 3: Apa kegunaan atribut WebClient?

Kegunaan dari Webclient adalah untuk menghubungkan personal komputer ke jaringan internet yang meminta informasi. Dalam mengakses webserver diperlukan sebuah WebClient untuk menggunakan aplikasi yaitu WebBrowser.

### Pertanyaan 4: Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?

ResponseEntity merupakan representasi keluruhan HTTP Response dari status code, header, dan body. Dengan demikian, dapat digunakan untuk mengkonfigurasi secara lengkap HTTP response.
BindingResult adalah sebuah objek spring yang akan menyimpan hasil validasi, binding, dan error dari model objek yang divalidasikan. Penggunaan BindingResult diletakkan setelah parameter objek divalidasi.

---

## Tutorial 4

### Pertanyaan 1: Jelaskan perbedaan th:include dan th:replace!

th:replace dan th:include adalah bentuk dari host tag. Kedua host tag ini mengimplementasikan bentuk fragment yang disediakan dari Thymeleaf. Fragment di sini merupakan reusable class yang mengimplement beberapa fitur. th:include merupakan akan memasukkan konten yan ada di fragments ke dalam tag hostnya, sedangakn th:replace memiliki fungsi untuk mengganti tag host dengan fragment yang artinya menghapus tag host dan sebagai pengganti tag host. Hal ini akan menambahkan fragment yang ditentukan termasuk tag fragment.

### Pertanyaan 2: Jelaskan apa fungsi dari th:object!

th:object digunakan untuk menentukan objek yang akan diisi. Selain itu, th:object juga akan digunakan untuk submit pada form. Dengan demikian akan mengetahui object apa yang di submit.

### Pertanyaan 3: Jelaskan perbedaan dari \* dan $ pada saat penggunaan th:object! Kapan harus dipakai?

perbedaan \* dan $ terdapat pada apa yang akan evaluasi, \_ akan mengavaluasi atribut atau variabel dari th:object yang sebelumnya sudah di-declare, sedangkan $ akan mengevaluasi keseluruhan atribut/variabel yang ada pada th:object.

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
