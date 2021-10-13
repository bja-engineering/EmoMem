package com.example.alex.emomem;

import android.os.Environment;
//import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ExternalStorageHelper {

    public ExternalStorageHelper() {

    }

    // Checks if external storage is available for read and write
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    // Checks if external storage is available to at least read
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public File getPublicAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        /*if (!file.mkdirs()) {
            Log.e(LOG_TAG, "Directory not created");
        }*/
        return file;
    }

    /*void write(String filename) {
        File file = new File(getExternalFilesDir(null), filename);

        try {
            OutputStream os = new FileOutputStream(file);

            os.write(data);

        } catch (IOException e) {
            Log.w("ExternalStorage", "Error writing " + file, e);

        } finally {
            os.close();

        }
    }*/

    /*void write {
        File file = new File(myContext.getExternalFilesDir(null), "state.txt");
        try {

            FileOutputStream os = new FileOutputStream(file, true);
            OutputStreamWriter out = new OutputStreamWriter(os);
            out.write(data);
            out.close();

        }
    }*/

    // Appends a string to a file on the external file system (! check file system permissions on target device !)
    public void appendEntryToFile(String fileName, String entry) {
        FileOutputStream outputStream;

        try {
            File f = new File(Environment.getExternalStorageDirectory(), fileName);
            outputStream = new FileOutputStream(f, true);
            OutputStreamWriter osWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bWriter = new BufferedWriter (osWriter);

            bWriter.append(entry);
            bWriter.newLine();
            bWriter.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // Deletes a file :)
    public void deleteFile(String fileName) {
        File f = new File(Environment.getExternalStorageDirectory(), fileName);
        f.delete();
    }

}
