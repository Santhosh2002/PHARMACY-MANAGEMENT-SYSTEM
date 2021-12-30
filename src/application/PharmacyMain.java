package application;

import java.io.IOException;

import javafx.event.ActionEvent;

public abstract class PharmacyMain {
	
	public abstract void createconnection();
	
	public abstract void ShowSignin(ActionEvent event);
	
	public abstract void ShowSignup(ActionEvent event);
	
	public abstract void ShowHome(ActionEvent event);
	
	public abstract void ShowApply(ActionEvent event);
	
	public abstract void Reset(ActionEvent event);
	
	public abstract void Signup(ActionEvent event);
	
	public abstract void ShowAdmin(ActionEvent event)throws IOException;
	
	public abstract void ShowDoctor(ActionEvent event)throws IOException;
	
	public abstract void ShowPharmacist(ActionEvent event)throws IOException;
	
	public abstract void Apply(ActionEvent event);
	
	public abstract void Reset2(ActionEvent event);
	
	public abstract void Signin(ActionEvent event)throws IOException;
	
	public abstract void ForgotPassword(ActionEvent event);
	
	public abstract void Next(ActionEvent event);
}
