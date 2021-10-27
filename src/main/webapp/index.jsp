<%@ page import="ir.maktab.flightticket.util.HibernateUtil" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="ir.maktab.flightticket.domain.Admin" %>
<%@ page import="ir.maktab.flightticket.domain.enumetarion.UserType" %>
<%@ page import="ir.maktab.flightticket.util.ApplicationContext" %>
<html>
<head>
    <link rel="stylesheet" href="resource/styles/style.css">
    <title>Maktab Flight Ticket</title>
</head>
<body>
<%
    EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    if (!ApplicationContext.getAdminService().existById(1L)){
        entityManager.getTransaction().begin();
        Admin admin = new Admin("admin", "admin", "3240782375", UserType.ADMIN);
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
    }
%>
<h1>Flight Ticket Reservation</h1>
<h2> Welcome to Maktab Flight Service </h2>
<div id='divMenu'>
    <ul>
        <li><a href="signUp">Customer Sign Up</a></li>
    </ul>
    <ul>
        <li><a href="signIn">Sign In</a></li>
    </ul>
</div>
</body>
</html>
