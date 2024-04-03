<?php

//include PHPMailerAutoload.php
	// require 'PHPMailer/PHPMailerAutoload.php';
	// require_once('phpmailer/class.phpmailer.php');
    use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;
use PHPMailer\PHPMailer\Exception;


/* Exception class. */
require 'C:\xampp\htdocs\projekt\PHPMailer\src\Exception.php';

/* The main PHPMailer class. */
require 'C:\xampp\htdocs\projekt\PHPMailer\src\PHPMailer.php';

/* SMTP class, needed if you want to use SMTP. */
require 'C:\xampp\htdocs\projekt\PHPMailer\src\SMTP.php';


// create user
	define('GUSER', 'botardoraphp@gmail.com'); // GMail username
	define('GPWD', 'phpprojekt'); // GMail password

	function smtpmailer($to, $from, $from_name, $subject, $body) { 
		 global $error;
		 $mail = new PHPMailer();  // create a new object
		 $mail->IsSMTP(); // enable SMTP
		 $mail->SMTPDebug = 0;  // debugging: 1 = errors and messages, 2 = messages only
		 $mail->SMTPAuth = true;  // authentication enabled
		 $mail->SMTPSecure = 'ssl'; // secure transfer enabled REQUIRED for GMail
		 $mail->Host = 'smtp.gmail.com';
		 $mail->Port = 465; 
		 $mail->Username = GUSER;  
		 $mail->Password = GPWD;           
		 $mail->SetFrom($from, $from_name);
		 $mail->Subject = $subject;
		 $mail->Body = $body;
		 $mail->AddAddress($to);
		 if(!$mail->Send()) {
			 $error = 'Mail error: '.$mail->ErrorInfo; 
			 return false;
		 } else {
			 $error = 'Message sent!';
			 return true;
		 }
	}

	// if (smtpmailer('botardoraphp@gmail.com', 'botardoraphp@gmail.com', 'Botar Dora', 'Sikeres regisztracio', 'Sikeresen regisztráltál a Erdélyi Magyar Informatikusok konferenciájának honlapjára. Itt minden információt megkapsz, ami az eseménnyel kapcsolatos. <br> Üdvözlettel, a szervező csapat.')){
	// 	echo "Mail sent";
	// } else {
	// 	echo "$error";
	// 	echo "Something wrong happened";
	// }

?>