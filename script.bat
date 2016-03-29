del /F /S /Q /A "D:\Program Files\Apache Software Foundation\Tomcat 7.0\logs\*"  
del /F /S /Q /A "D:\Program Files\Apache Software Foundation\Tomcat 7.0\work\Catalina\*"
del /F /S /Q /A "D:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\CRUDapplication*"
@echo log files deleted
copy "F:\softwares\eclipse\CrudApplication\target\*.*" "D:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps"
@echo War file copied
