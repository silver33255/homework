package ua.kharkov.knure.dkolesnikov.st4example.web.command;

import org.apache.log4j.Logger;
import ua.kharkov.knure.dkolesnikov.st4example.Path;
import ua.kharkov.knure.dkolesnikov.st4example.db.Role;
import ua.kharkov.knure.dkolesnikov.st4example.db.UserDao;
import ua.kharkov.knure.dkolesnikov.st4example.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

/**
 * Login command.
 * 
 * @author D.Kolesnikov
 * 
 */
public class LoginCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;
	
	private static final Logger log = Logger.getLogger(LoginCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		log.debug("Command starts");
		
		HttpSession session = request.getSession();
		
		// obtain login and password from the request
		String login = request.getParameter("login");
		log.trace("Request parameter: loging --> " + login);
		
		String password = request.getParameter("password");
		
		// error handler
		String errorMessage = null;		
		String forward = Path.PAGE__ERROR_PAGE;
		
		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			errorMessage = "Login/password cannot be empty";
			request.setAttribute("errorMessage", errorMessage);
			log.error("errorMessage --> " + errorMessage);
			return forward;
		}
		
		User user = new UserDao().findUserByLogin(login);
		log.trace("Found in DB: user --> " + user);
			
		if (user == null || !password.equals(user.getPassword())) {
			errorMessage = "Cannot find user with such login/password";
			request.setAttribute("errorMessage", errorMessage);
			log.error("errorMessage --> " + errorMessage);
			return forward;
		} else {
			Role userRole = Role.getRole(user);
			log.trace("userRole --> " + userRole);
				
			if (userRole == Role.ADMIN)
				forward = Path.COMMAND__LIST_ORDERS;
		
			if (userRole == Role.CLIENT)
				forward = Path.COMMAND__LIST_MENU;
			
			session.setAttribute("user", user);
			log.trace("Set the session attribute: user --> " + user);
				
			session.setAttribute("userRole", userRole);				
			log.trace("Set the session attribute: userRole --> " + userRole);
				
			log.info("User " + user + " logged as " + userRole.toString().toLowerCase());
			
			// work with i18n
			String userLocaleName = user.getLocaleName();
			log.trace("userLocalName --> " + userLocaleName);
			
			if (userLocaleName != null && !userLocaleName.isEmpty()) {
				Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", userLocaleName);
				
				session.setAttribute("defaultLocale", userLocaleName);
				log.trace("Set the session attribute: defaultLocaleName --> " + userLocaleName);
				
				log.info("Locale for user: defaultLocale --> " + userLocaleName);
			}
		}
		
		log.debug("Command finished");
		return forward;
	}

}