<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/20/2016
  Time: 4:46 PM
--%>

<g:form controller="category" action="update" id="${category.id}">
    <label>Class: </label>
    <g:textField name="type" value="${category.type}"/><br/>
    <label>Price: </label>
    <g:textField name="price" value="${category.price}"/><br/>
    <g:actionSubmit value="Save"/>
</g:form>