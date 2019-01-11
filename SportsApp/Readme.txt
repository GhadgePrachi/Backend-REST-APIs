Project Flow :
	MainModule :
		SportsAppDriver.java : Initializes/Configs the application framework (Spring framework) and scans it's components.
		MyBatisConnectionFactory.java : Sets up a database(DB) connection factory using mybatis-config.xml.
	SubModules :
		Controllers : Processes the request url and redirects to the respective services.
			SportsAppController.java 
		Services : Consists of Restful Services Classes that communicate with DAO classes to access or send data.
			UserService.java etc //interfaces
			UserServiceImp.java etc
		DataAccessObject(DAO) : Communicates with Mapper files to fire queries after establishing a DB connection and closing it once required data is fetched or updated.
			UserDAO.java etc//interfaces
			UserDAOImp.java etc
		EntityModel : Provides a well defined structure for data communication between DAO and DB.
			User.java, Error.java etc
		Mappers : Selecting DB Queries
			UserMapper.java etc//interfaces
		Providers : Building DB Queries
			UserProvider.java etc
		Resources :
			mybatis-config.xml : Has DB configuration settings
		
FUTURE FEATURES :
	Social media integration

