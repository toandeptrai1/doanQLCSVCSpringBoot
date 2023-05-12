package com.doan.QLCSVC.service;

import com.doan.QLCSVC.model.TaiSan;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;

@Service
public class QRCodeService {
    public  String generateQRCodeImage(TaiSan taiSan) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(taiSan.toString(), BarcodeFormat.QR_CODE, 200, 200);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        String image= UUID.randomUUID().toString() +"QR.png";
        MatrixToImageWriter.writeToFile(bitMatrix, "PNG",new File("D:\\Dowload\\QLCSVC\\QLCSVC\\uploads\\"+image));
        byte[] pngByteArray = outputStream.toByteArray();

        return image;
    }
}
