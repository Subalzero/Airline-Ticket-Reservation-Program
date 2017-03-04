/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Acer
 */
@SuppressWarnings("serial")
public class NoSuchElementException extends RuntimeException {
    public NoSuchElementException() {
	this("No such element exists.");
    }
    public NoSuchElementException(String exception) {
	super(exception);
    }

}
