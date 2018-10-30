# Backend-REST-APIs

## Project Flow :

### MainModule :
   + MusicCloudDriver.java : Initializes/Configs the application framework (Spring framework) and scans it's components MusicCloudController.java.
   + MyBatisConnectionFactory.java : Sets up a database(DB) connection factory using mybatis-config.xml.

### SubModules :    
+ Controllers :
  + MusicCloudController.java : Processes the request url and redirects to the respective services.
+ Services : Consists of Restful Services Classes that communicate with DAO classes to access or send data.
   + SongService.java, UserService.java //interfaces 
   + SongServiceImp.java, UserServiceImp.java 
+ DataAccessObject(DAO) : Communicates with Mapper files to fire queries after establishing a DB connection and closing it once required data is fetched or updated.
   + SongDAO.java, UserDAO.java //interfaces 
   + SongDAOImp.java, UserDAOImp.java 
+ EntityModel : Provides a well defined structure for data communication between DAO and DB.
   + Song.java, User.java, Error.java 
+ Mappers : Have DB Queries
   + SongMapper.java, UserMapper.java //interfaces
+ Resources :
   + mybatis-config.xml : Has DB config settings
   
### FUTURE FEATURES  :   
+ Playlist Feature to maintain a collection of songs.

