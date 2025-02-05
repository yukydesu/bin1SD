public class Login {
   
 	private String login;
	
 	public Login(String login)throws IllegalArgumentException{
		if(login==null || login.length() != 7 || (!login.substring(0,4).equals("info")&&
				!login.substring(0,4).equals("mark")&&!login.substring(0,4).equals("admi")))
			throw new IllegalArgumentException("login incorrect");
		this.login = login;
	}

	public String toString(){
		return "/n"+login +"   "+login;
	}

	// renvoie un entier >= 0
	// cet entier represente de fa�on unique le login courant!
	public int hashCode(){
		// TODO /

		int index = Integer.parseInt(login.substring(4)) - 1;
		String subStringLogin = login.substring(0, 4);

		if (subStringLogin.equals("info"))
			return index;

		if (subStringLogin.equals("mark"))
			return index + 137;

		return index + 137 + 73;
	 }
	
}

