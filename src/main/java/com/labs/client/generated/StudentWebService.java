
package com.labs.client.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentWebService", targetNamespace = "http://labs.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentWebService {


    /**
     * 
     * @param studentId
     * @param studentAge
     * @param studentSurname
     * @param studentName
     * @param studentMark
     * @param rowId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateStudent", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.UpdateStudent")
    @ResponseWrapper(localName = "updateStudentResponse", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.UpdateStudentResponse")
    @Action(input = "http://labs.com/StudentWebService/updateStudentRequest", output = "http://labs.com/StudentWebService/updateStudentResponse")
    public String updateStudent(
        @WebParam(name = "rowId", targetNamespace = "")
        int rowId,
        @WebParam(name = "studentName", targetNamespace = "")
        String studentName,
        @WebParam(name = "studentSurname", targetNamespace = "")
        String studentSurname,
        @WebParam(name = "studentAge", targetNamespace = "")
        int studentAge,
        @WebParam(name = "studentId", targetNamespace = "")
        int studentId,
        @WebParam(name = "studentMark", targetNamespace = "")
        String studentMark);

    /**
     * 
     * @param rowId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteStudent", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.DeleteStudent")
    @ResponseWrapper(localName = "deleteStudentResponse", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.DeleteStudentResponse")
    @Action(input = "http://labs.com/StudentWebService/deleteStudentRequest", output = "http://labs.com/StudentWebService/deleteStudentResponse")
    public String deleteStudent(
        @WebParam(name = "rowId", targetNamespace = "")
        int rowId);

    /**
     * 
     * @param studentId
     * @param studentAge
     * @param studentSurname
     * @param studentName
     * @param studentMark
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createStudent", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.CreateStudent")
    @ResponseWrapper(localName = "createStudentResponse", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.CreateStudentResponse")
    @Action(input = "http://labs.com/StudentWebService/createStudentRequest", output = "http://labs.com/StudentWebService/createStudentResponse")
    public String createStudent(
        @WebParam(name = "studentName", targetNamespace = "")
        String studentName,
        @WebParam(name = "studentSurname", targetNamespace = "")
        String studentSurname,
        @WebParam(name = "studentAge", targetNamespace = "")
        int studentAge,
        @WebParam(name = "studentId", targetNamespace = "")
        int studentId,
        @WebParam(name = "studentMark", targetNamespace = "")
        String studentMark);

    /**
     * 
     * @param fieldValue
     * @return
     *     returns java.util.List<com.labs.client.generated.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentsByFields", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.GetStudentsByFields")
    @ResponseWrapper(localName = "getStudentsByFieldsResponse", targetNamespace = "http://labs.com/", className = "com.labs.client.generated.GetStudentsByFieldsResponse")
    @Action(input = "http://labs.com/StudentWebService/getStudentsByFieldsRequest", output = "http://labs.com/StudentWebService/getStudentsByFieldsResponse")
    public List<Student> getStudentsByFields(
        @WebParam(name = "fieldValue", targetNamespace = "")
        List<String> fieldValue);

}
