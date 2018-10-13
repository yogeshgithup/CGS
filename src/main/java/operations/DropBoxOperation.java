

package operation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.http.SSLConfig;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.CreateFolderErrorException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.dropbox.core.v2.users.FullAccount;

public class DropBoxOperation {
    private DbxRequestConfig config = null;
    DbxClientV2 client = null;
    FullAccount account = null;
    
    public DropBoxOperation(String ACCESS_TOKEN)
    {
        // Create Dropbox client
        config = new DbxRequestConfig("text-edit/0.1");
        client = new DbxClientV2(config, ACCESS_TOKEN);
        
        try {
            FullAccount account = client.users().getCurrentAccount();
            System.out.println(account.getName().getDisplayName());
        }
        catch (DbxException dbxe)
        {
            dbxe.printStackTrace();
        }
    }
    
    public void createFolder(String folderName) throws DbxException {
        try {
            FolderMetadata folder = client.files().createFolder(folderName);
            System.out.println(folder.getName());
        } catch (CreateFolderErrorException err) {
            if (err.errorValue.isPath() && err.errorValue.getPathValue().isConflict()) {
                System.out.println("Something already exists at the path.");
            } else {
                System.out.print("Some other CreateFolderErrorException occurred...");
                System.out.print(err.toString());
            }
        } catch (Exception err) {
            System.out.print("Some other Exception occurred...");
            System.out.print(err.toString());
        }
    }

    public void listFolder()
    {
        try
        {
            // Get files and folder metadata from Dropbox root directory
            ListFolderResult result = client.files().listFolder("");
            while (true) {
                for (Metadata metadata : result.getEntries()) {
                    System.out.println(metadata.getPathLower());
                }
    
                if (!result.getHasMore()) {
                    break;
                }
    
                result = client.files().listFolderContinue(result.getCursor());
            }
        }
        catch (DbxException dbxe)
        {
            dbxe.printStackTrace();
        }         
    }
    
    public void uploadFile(String path, String foldername)
    {
        // Upload "test.txt" to Dropbox
        try {
            InputStream in = new FileInputStream(path);
            FileMetadata metadata = client.files().uploadBuilder(foldername).uploadAndFinish(in);
        }
        catch (FileNotFoundException fne)
        {
            System.out.println("96 : FileNotFoundException Caused By "+fne.getLocalizedMessage());
        }
        catch (IOException ioe)
        {
            System.out.println("100 : IOException Caused By "+ioe.getLocalizedMessage());
        }
        catch (DbxException dbxe)
        {
            
            System.out.println("105 : DbxException Caused By "+dbxe.getLocalizedMessage());
        }
    }
    public String  uploadFile(String filename, InputStream is)
    {
        // Upload "test.txt" to Dropbox
        String url=null;
        try {
         
            FileMetadata metadata = client.files().uploadBuilder("/"+filename).uploadAndFinish(is);
             SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings("/"+filename);
              url=sharedLinkMetadata.getUrl();
              url=url.substring(0, url.length()-1)+"1";
            
        }
         catch (FileNotFoundException fne)
        {
            System.out.println("96 : FileNotFoundException Caused By "+fne.getLocalizedMessage());
        }
        catch (IOException ioe)
        {
            System.out.println("100 : IOException Caused By "+ioe.getLocalizedMessage());
        }
        catch (DbxException dbxe)
        {
            
            System.out.println("105 : DbxException Caused By "+dbxe.getLocalizedMessage());
        }
       return url;
    }
    
    public void readFile(String foldername, String filename)
    {
        try
        {
            //output file for download --> storage location on local system to download file
            FileOutputStream downloadFile = new FileOutputStream("c:/" + filename);
            try {
                FileMetadata metadata = client.files().downloadBuilder(foldername).download(downloadFile);
                } finally
                {
                    downloadFile.close();
                }
        }
        //exception handled
        catch (DbxException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void deleteFile(String filename)
    {
        try
        {
            Metadata metadata = client.files().delete('/'+filename);
        }
        catch (DbxException dbxe)
        {
            dbxe.printStackTrace();
        }
    }
}
