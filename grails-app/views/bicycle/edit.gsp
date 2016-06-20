
<g:form controller="bicycle" action="update" id="${bicycle.id}">
    <label>Category: </label>
    <g:select from="${category.type}" name="category"/><br/>
    <label>Title: </label>
    <g:textField name="title" value="${bicycle.title}"/><br/>
    <label>Quantity: </label>
    <g:textField name="quantity" value="${bicycle.quantity}"/><br/>
    <label>Date: </label>
    <g:datePicker name="date" value="${bicycle.date}"/><br/>
    <label>Price: </label>
    <g:textField name="totalPrice" value="${bicycle.totalPrice}"/><br/>
    <label>Description: </label>
    <g:textField name="description" value="${bicycle.description}"/><br/>
    <g:actionSubmit value="Update"/>
</g:form>