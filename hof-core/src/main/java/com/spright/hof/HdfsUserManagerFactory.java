package com.spright.hof;

import java.io.File;
import java.net.URL;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.usermanager.Md5PasswordEncryptor;
import org.apache.ftpserver.usermanager.PasswordEncryptor;
import org.apache.ftpserver.usermanager.UserManagerFactory;

public class HdfsUserManagerFactory implements UserManagerFactory {

  private String adminName = "admin";
  private File userDataFile;
  private URL userDataURL;
  private PasswordEncryptor passwordEncryptor = new Md5PasswordEncryptor();

  @Override
  public UserManager createUserManager() {
    if (userDataURL != null) {
      return new HdfsUserManager(passwordEncryptor, userDataURL,
              adminName);
    } else {

      return new HdfsUserManager(passwordEncryptor, userDataFile,
              adminName);
    }
  }

  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }

  public File getFile() {
    return userDataFile;
  }

  public void setFile(File propFile) {
    this.userDataFile = propFile;
  }

  public URL getUrl() {
    return userDataURL;
  }

  public void setUrl(URL userDataURL) {
    this.userDataURL = userDataURL;
  }

  public PasswordEncryptor getPasswordEncryptor() {
    return passwordEncryptor;
  }

  public void setPasswordEncryptor(PasswordEncryptor passwordEncryptor) {
    this.passwordEncryptor = passwordEncryptor;
  }
}
