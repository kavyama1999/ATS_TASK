/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service.persistence;

import AmbulanceDb2.exception.NoSuchAmbSignUpException;

import AmbulanceDb2.model.AmbSignUp;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amb sign up service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmbSignUpUtil
 * @generated
 */
@ProviderType
public interface AmbSignUpPersistence extends BasePersistence<AmbSignUp> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmbSignUpUtil} to access the amb sign up persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amb sign ups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid(String uuid);

	/**
	 * Returns a range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public AmbSignUp findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
				orderByComparator)
		throws NoSuchAmbSignUpException;

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public AmbSignUp fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator);

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public AmbSignUp findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
				orderByComparator)
		throws NoSuchAmbSignUpException;

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public AmbSignUp fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator);

	/**
	 * Returns the amb sign ups before and after the current amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param otpId the primary key of the current amb sign up
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public AmbSignUp[] findByUuid_PrevAndNext(
			long otpId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
				orderByComparator)
		throws NoSuchAmbSignUpException;

	/**
	 * Removes all the amb sign ups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of amb sign ups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amb sign ups
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAmbSignUpException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public AmbSignUp findByUUID_G(String uuid, long groupId)
		throws NoSuchAmbSignUpException;

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public AmbSignUp fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public AmbSignUp fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the amb sign up where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amb sign up that was removed
	 */
	public AmbSignUp removeByUUID_G(String uuid, long groupId)
		throws NoSuchAmbSignUpException;

	/**
	 * Returns the number of amb sign ups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amb sign ups
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amb sign ups
	 */
	public java.util.List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public AmbSignUp findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
				orderByComparator)
		throws NoSuchAmbSignUpException;

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public AmbSignUp fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator);

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public AmbSignUp findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
				orderByComparator)
		throws NoSuchAmbSignUpException;

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public AmbSignUp fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator);

	/**
	 * Returns the amb sign ups before and after the current amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param otpId the primary key of the current amb sign up
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public AmbSignUp[] findByUuid_C_PrevAndNext(
			long otpId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
				orderByComparator)
		throws NoSuchAmbSignUpException;

	/**
	 * Removes all the amb sign ups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amb sign ups
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the amb sign up in the entity cache if it is enabled.
	 *
	 * @param ambSignUp the amb sign up
	 */
	public void cacheResult(AmbSignUp ambSignUp);

	/**
	 * Caches the amb sign ups in the entity cache if it is enabled.
	 *
	 * @param ambSignUps the amb sign ups
	 */
	public void cacheResult(java.util.List<AmbSignUp> ambSignUps);

	/**
	 * Creates a new amb sign up with the primary key. Does not add the amb sign up to the database.
	 *
	 * @param otpId the primary key for the new amb sign up
	 * @return the new amb sign up
	 */
	public AmbSignUp create(long otpId);

	/**
	 * Removes the amb sign up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up that was removed
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public AmbSignUp remove(long otpId) throws NoSuchAmbSignUpException;

	public AmbSignUp updateImpl(AmbSignUp ambSignUp);

	/**
	 * Returns the amb sign up with the primary key or throws a <code>NoSuchAmbSignUpException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public AmbSignUp findByPrimaryKey(long otpId)
		throws NoSuchAmbSignUpException;

	/**
	 * Returns the amb sign up with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up, or <code>null</code> if a amb sign up with the primary key could not be found
	 */
	public AmbSignUp fetchByPrimaryKey(long otpId);

	/**
	 * Returns all the amb sign ups.
	 *
	 * @return the amb sign ups
	 */
	public java.util.List<AmbSignUp> findAll();

	/**
	 * Returns a range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of amb sign ups
	 */
	public java.util.List<AmbSignUp> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amb sign ups
	 */
	public java.util.List<AmbSignUp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amb sign ups
	 */
	public java.util.List<AmbSignUp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmbSignUp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amb sign ups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amb sign ups.
	 *
	 * @return the number of amb sign ups
	 */
	public int countAll();

}