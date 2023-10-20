<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tambah Data Mahasiswa</title>
    <link href='https://fonts.googleapis.com/css?family=Inter' rel='stylesheet'>
    <link href="../../resources/style.css" rel="stylesheet">
</head>
<body>

<br/>
<div class="form-container">
    <h3>${result}</h3>
    <p>Nama: ${name}</p>
    <p>NIM: ${nim}</p>
    <p>Alamat: ${address}</p>
    <p>Tanggal Lahir: ${birthday}</p>
    <button class="button-href" onclick="location.href='../..'">Kembali</button>
    <button class="button-href" onclick="location.href='mahasiswa'">Lihat Data Mahasiswa</button>
</div>

</body>
</html>