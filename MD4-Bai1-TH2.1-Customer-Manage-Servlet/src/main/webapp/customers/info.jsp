
<%@ page import="rikkei.academy.service.CustomerService" %>
<%@ page import="rikkei.academy.service.CustomerServiceFactory" %>
<%@ page import="rikkei.academy.model.Customer" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>

<form action="<%=request.getContextPath()%>/CustomerController/update" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="${customer.id}">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    ${customer.id}
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${customer.name}">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" name="email" value="${customer.email}">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" value="${customer.address}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customers/list.jsp">Back to list</a>.