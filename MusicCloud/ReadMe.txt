Project Flow :

    MainModule :
        PlaylistDriver.java : Initializes/Configs the application framework (Spring framework) and scans it's components (MainController.java).
        MyBatisConnectionFactory.java : Sets up a database(DB) connection factory using mybatis-config.xml.

    SubModules :
        a)Controllers : Processes the request url and redirects to the respective services.
            MainController.java

        b)Services : Consists of Restful Services Classes that communicate with DAO classes to access or send data.
            PlaylistService.java, SongService.java, UserService.java //interfaces
            PlaylistServiceImp.java, SongServiceImp.java, UserServiceImp.java

        c)DataAccessObject(DAO) : Communicates with Mapper files to fire queries after establishing a DB connection and closing it once required data is fetched or updated.
            PlaylistDAO.java, SongDAO.java, UserDAO.java //interfaces
            PlaylistDAOImp.java, SongDAOImp.java, UserDAOImp.java

        d)EntityModel : Provides a well defined structure for data communication between DAO and DB.
            Playlist.java, Song.java, User.java, Error.java

        e)Mappers : Have DB Queries
            PlaylistMapper.java, SongMapper.java, UserMapper.java //interfaces

        e)Resources :
            mybatis-config.xml : Has DB config settings


