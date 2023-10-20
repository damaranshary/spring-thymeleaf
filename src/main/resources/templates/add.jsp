<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Data Mahasiswa</title>
    <link href="../../resources/style.css" rel="stylesheet">
</head>
<body>
<div class="form-container">
    <h2>Form Mahasiswa</h2>
    <form action="/mahasiswa/tambah" method="post">
        <label for="name">Nama Lengkap</label>
        <input type="text" name="name" id="name" required/>
        <label for="nim">NIM</label>
        <input type="number" name="nim" id="nim" required/>
        <label for="address">Alamat Lengkap</label>
        <textarea name="address" id="address" required></textarea>
        <label for="birthday">Tanggal Lahir</label>
        <input type="date" name="birthday" id="birthday" required/>
        <button class="button-submit" type="submit">Submit</button>
    </form>
    <button class="button-href" onclick="location.href='mahasiswa'">Lihat Data Mahasiswa</button>
</div>
</body>
</html>