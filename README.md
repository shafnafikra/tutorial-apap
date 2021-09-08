# Tutorial APAP
## Authors
* **Fikra Shafna Rahmania Putri Setyawan** - *1906304175* - *APAP-C*

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
* https://www.geeksforgeeks.org/introduction-apache-maven-build-automation-tool-java-projects/
* https://www.idtech.com/blog/what-are-libraries-in-coding
* https://coderslegacy.com/what-are-dependencies-in-programming/
* https://reqtest.com/requirements-blog/what-are-benefits-of-version-control/
* https://devblogs.microsoft.com/devops/squash-a-whole-new-way-to-merge-pull-requests/
* https://cloudfour.com/thinks/squashing-your-pull-requests/ 
* https://www.zendesk.com/blog/issue-tracker/
