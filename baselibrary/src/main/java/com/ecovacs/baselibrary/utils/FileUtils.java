package com.ecovacs.baselibrary.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by liang.liu on 2018/3/9.
 */

public class FileUtils {

    public static void closeIO(Closeable... closeables) {
        if (null == closeables || closeables.length <= 0) {
            return;
        }


        try {
            for (Closeable closeable : closeables) {
                if (null == closeable) {
                    continue;
                }
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 文件是否存在
     *
     * @param filePath
     * @return
     */
    public static boolean isFileExist(String filePath) {
        return new File(filePath).exists();
    }

    public static boolean deleteFile(String filename) {
        return new File(filename).delete();
    }


    public static void deleteFileByDirectory(File directory) {
        if (directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    /**
     * 写文件
     *
     * @param filename
     * @param content
     * @param append
     * @return
     */
    public static boolean writeFile(String filename, String content, boolean append) {

        boolean isSuccess = false;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filename, append));
            bufferedWriter.write(content);
            isSuccess = true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO();
        }

        return isSuccess;
    }


    public static String readFile(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {
            return null;
        }

        BufferedReader bufferedReader = null;
        String str = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            str = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

    public static StringBuilder readFile(File file, String charsetName) {
        StringBuilder fileContent = new StringBuilder("");
        if (file == null || !file.isFile()) {
            return null;
        }

        BufferedReader bufferedReader = null;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charsetName);

            bufferedReader = new BufferedReader(inputStreamReader);

            String line = null;

            if ((line = bufferedReader.readLine()) != null) {
                if (!fileContent.toString().equals("")) {
                    fileContent.append("\r\n");
                }

                fileContent.append(line);
            }

            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(bufferedReader);
        }

        return null;
    }


    public static void copyFile(InputStream in, OutputStream out) {

        try {
            byte[] b = new byte[2 * 1024 * 1024];  //2M memory

            int len = -1;

            while ((len = in.read(b)) > 0) {
                out.write(b, 0, len);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(in, out);
        }
    }


    public static void copyFile(File in, File out) {

        FileChannel filein = null;
        FileChannel fileout = null;

        try {
            filein = new FileInputStream(in).getChannel();
            fileout = new FileOutputStream(out).getChannel();

            filein.transferTo(0, filein.size(), fileout);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(filein, fileout);
        }

    }

    public static void shareFile(Context context, String title, String filePath) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        Uri uri = Uri.parse("file://" + filePath);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        context.startActivity(Intent.createChooser(intent, title));
    }

    public static void zip(InputStream in, OutputStream out) {

        GZIPOutputStream gzip = null;

        try {
            gzip = new GZIPOutputStream(out);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read()) > 0) {
                gzip.write(buf, 0, len);
                gzip.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(gzip);
        }
    }

    public static void unzip(InputStream in, OutputStream out) {
        GZIPInputStream gzip = null;

        try {
            gzip = new GZIPInputStream(in);
            byte[] buf = new byte[1024];
            int len;

            while ((len = gzip.read(buf)) != -1) {
                out.write(buf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(gzip, out);
        }

    }

    public static void stream2file(InputStream inputStream, File file) {
        byte[] b = new byte[1024];
        int len;

        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
                outputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(outputStream, inputStream);
        }
    }

    /**
     * 创建文件
     *
     * @param filePath
     * @return
     */
    public static boolean createFolder(String filePath) {
        return createFolder(filePath, false);
    }

    private static boolean createFolder(String filePath, boolean recreate) {
        String folderName = getFolderName(filePath);
        if (folderName == null || folderName.length() == 0 || folderName.trim().length() == 0) {
            return false;
        }

        File folder = new File(folderName);
        if (folder.exists()) {
            if (recreate) {
                deleteFile(folderName);
                return folder.mkdirs();
            } else {
                return true;
            }
        } else {
            return folder.mkdirs();
        }
    }

    public static String getFileName(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return filePath;
        }

        int filePosi = filePath.lastIndexOf(File.separator);
        return (filePosi == -1) ? filePath : filePath.substring(filePosi + 1);
    }

    public static long getFileSize(String filepath) {
        if (TextUtils.isEmpty(filepath)) {
            return -1;
        }
        File file = new File(filepath);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }

    public static boolean rename(String filepath, String newName) {
        File file = new File(filepath);
        return file.exists() && file.renameTo(new File(newName));
    }

    public static ArrayList<File> getFilesArray(String path) {
        File file = new File(path);
        File files[] = file.listFiles();
        ArrayList<File> listFile = new ArrayList<File>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    listFile.add(files[i]);
                }
                if (files[i].isDirectory()) {
                    listFile.addAll(getFilesArray(files[i].toString()));
                }
            }
        }
        return listFile;
    }

    private static boolean deleteFiles(String folder) {
        if (folder == null || folder.length() == 0 || folder.trim().length() == 0) {
            return true;
        }

        File file = new File(folder);
        if (!file.exists()) {
            return true;
        }

        if (file.isFile()) {
            return file.delete();
        }

        if (!file.isDirectory()) {
            return false;
        }

        for (File f : file.listFiles()) {
            if (f.isFile()) {
                f.delete();
            } else if (f.isDirectory()) {
                deleteFile(f.getAbsolutePath());
            }
        }

        return file.delete();
    }

    /**
     * 获取文件夹名
     *
     * @param filePath
     * @return
     */
    private static String getFolderName(String filePath) {
        if (filePath == null || filePath.length() == 0 || filePath.trim().length() == 0) {
            return filePath;
        }

        int filePos = filePath.lastIndexOf(File.separator);

        return (filePos == -1) ? "" : filePath.substring(0, filePos);
    }

    public static void openImage(Context mContext, String imagePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(imagePath));
        intent.setDataAndType(uri, "image/*");
        mContext.startActivity(intent);
    }

    public static void openVideo(Context mContext, String videoPath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(videoPath));
        intent.setDataAndType(uri, "video/*");
        mContext.startActivity(intent);
    }

    public static void openURL(Context mContext, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        mContext.startActivity(intent);
    }

    public static void downloadFile(Context context, String fileurl) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(fileurl));
        request.setDestinationInExternalPublicDir("/Download/", fileurl.substring(fileurl.lastIndexOf("/") + 1));
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }


    public static boolean isSDCardAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static String getAppExternalPath(Context context) {

        return context.getObbDir().getAbsolutePath();
    }

    @Deprecated
    public static String getExtraPath(String folder) {
        String storagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + folder;
        File file = new File(storagePath);
        if (!file.exists()) {
            file.mkdir();
        }
        return storagePath;
    }
}
