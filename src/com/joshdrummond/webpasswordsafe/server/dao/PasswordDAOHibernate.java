/*
    Copyright 2008 Josh Drummond

    This file is part of WebPasswordSafe.

    WebPasswordSafe is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    WebPasswordSafe is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with WebPasswordSafe; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.joshdrummond.webpasswordsafe.server.dao;

import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.joshdrummond.webpasswordsafe.common.model.Password;

/**
 * DAO implementation for Password
 * 
 * @author Josh Drummond
 *
 */
public class PasswordDAOHibernate extends GenericHibernateDAO<Password, Long> implements PasswordDAO
{

    /* (non-Javadoc)
     * @see com.joshdrummond.webpasswordsafe.server.dao.PasswordDAO#findPasswordByFuzzySearch(java.lang.String)
     */
    public List<Password> findPasswordByFuzzySearch(String query)
    {
        return findByCriteria(Restrictions.or(
               Restrictions.ilike("username", query, MatchMode.ANYWHERE), 
               Restrictions.ilike("name", query, MatchMode.ANYWHERE)));
    }

}