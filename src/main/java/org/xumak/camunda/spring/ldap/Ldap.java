package org.xumak.camunda.spring.ldap;

/**
 * Created by gsaldana on 9/4/16.
 */

import org.xumak.camunda.spring.bean.GroupBean;
import org.xumak.camunda.spring.bean.UserBean;
import org.xumak.camunda.spring.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.directory.*;

public class Ldap {

    private static final Hashtable env;

    static {
        env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, Constants.INITIAL_CONTEXT_FACTORY);
        env.put(Context.PROVIDER_URL, Constants.PROVIDER_URL);
        env.put(Context.SECURITY_AUTHENTICATION, Constants.SECURITY_AUTHENTICATION);
        env.put(Context.SECURITY_PRINCIPAL, Constants.SECURITY_PRINCIPAL);
        env.put(Context.SECURITY_CREDENTIALS, Constants.SECURITY_CREDENTIALS);
    }

    public List<UserBean> getAllUsers() {

        List<UserBean> listOfUsers = new ArrayList<UserBean>();

        DirContext ctx = null;
        NamingEnumeration results = null;

        try {
            ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            results = ctx.search("", "(objectClass=person)", controls);

            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();

                UserBean user = new UserBean();
                user.setFirstName(attributes.get("cn").get().toString());
                user.setLastName(attributes.get("sn").get().toString());
                user.setUid(attributes.get("uid").get().toString());
                user.setMail("");

                listOfUsers.add(user);
            }

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                }
            }
        }

        return listOfUsers;
    }

    public List<GroupBean> getGroupsNames() {

        List<GroupBean> listOfGroups = new ArrayList<GroupBean>();

        DirContext ctx = null;
        NamingEnumeration results = null;

        try {
            ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            results = ctx.search("", "(objectClass=groupOfNames)", controls);

            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();

                GroupBean group = new GroupBean();
                group.setName(attributes.get("cn").get().toString());
                listOfGroups.add(group);
            }

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                }
            }
        }

        return listOfGroups;
    }

    public List<UserBean> getUsersOfOtherGroup(String nameGroup) {

        List<UserBean> listUsersGroup = new ArrayList<UserBean>();

        List<String> listUsersGroupMember = new ArrayList<String>();

        DirContext ctx = null;
        NamingEnumeration results = null;

        try {
            ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            results = ctx.search("", "(&(objectClass=groupOfNames)(!(cn=" + nameGroup + ")))", controls);

            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("member");

                for (int i = 0; i < attr.size(); i++) {
                    listUsersGroupMember.add(attr.get(i).toString());
                }
            }


        } catch (NamingException e) {
            throw new RuntimeException(e);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                }
            }
        }


        for (String s : listUsersGroupMember) {

            try {
                ctx = new InitialDirContext(env);
                SearchControls controls = new SearchControls();
                controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
                int firstComma = s.indexOf(",");

                String cnValue = s.substring(0, firstComma);
                results = ctx.search("", "(&(objectClass=person)(" + cnValue + "))", controls);

                while (results.hasMore()) {
                    SearchResult searchResult = (SearchResult) results.next();
                    Attributes attributes = searchResult.getAttributes();

                    UserBean user = new UserBean();
                    user.setFirstName(attributes.get("cn").get().toString());
                    user.setLastName(attributes.get("sn").get().toString());
                    user.setUid(attributes.get("uid").get().toString());
                    user.setMail("");

                    listUsersGroup.add(user);
                }
            } catch (NamingException e) {
                throw new RuntimeException(e);
            } finally {
                if (results != null) {
                    try {
                        results.close();
                    } catch (Exception e) {
                    }
                }
                if (ctx != null) {
                    try {
                        ctx.close();
                    } catch (Exception e) {
                    }
                }
            }

        }

        return listUsersGroup;
    }

    public List<UserBean> getUsersOfGroup(String nameGroup) {

        List<UserBean> listUsersGroup = new ArrayList<UserBean>();

        List<String> listUsersGroupMember = new ArrayList<String>();

        DirContext ctx = null;
        NamingEnumeration results = null;

        try {
            ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            results = ctx.search("", "(&(objectClass=groupOfNames)((cn=" + nameGroup + ")))", controls);

            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("member");

                for (int i = 0; i < attr.size(); i++) {
                    listUsersGroupMember.add(attr.get(i).toString());
                }
            }


        } catch (NamingException e) {
            throw new RuntimeException(e);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                }
            }
        }


        for (String s : listUsersGroupMember) {

            try {
                ctx = new InitialDirContext(env);
                SearchControls controls = new SearchControls();
                controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
                int firstComma = s.indexOf(",");

                String cnValue = s.substring(0, firstComma);
                results = ctx.search("", "(&(objectClass=person)(" + cnValue + "))", controls);

                while (results.hasMore()) {
                    SearchResult searchResult = (SearchResult) results.next();
                    Attributes attributes = searchResult.getAttributes();

                    UserBean user = new UserBean();
                    user.setFirstName(attributes.get("cn").get().toString());
                    user.setLastName(attributes.get("sn").get().toString());
                    user.setUid(attributes.get("uid").get().toString());
                    user.setMail("");

                    listUsersGroup.add(user);
                }
            } catch (NamingException e) {
                throw new RuntimeException(e);
            } finally {
                if (results != null) {
                    try {
                        results.close();
                    } catch (Exception e) {
                    }
                }
                if (ctx != null) {
                    try {
                        ctx.close();
                    } catch (Exception e) {
                    }
                }
            }

        }

        return listUsersGroup;
    }

}
