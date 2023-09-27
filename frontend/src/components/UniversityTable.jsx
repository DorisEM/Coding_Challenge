import React, { useState, useEffect } from 'react';
import '../App.css';

const UniversityTable = () => {
    const [universities, setUniversities] = useState([]);
    const [sortType, setSortType] = useState('id'); 

    useEffect(() => {
        fetchUniversities();
    }, [sortType]);

    const fetchUniversities = async () => {
        let url = 'http://localhost:9090/universities';
        if (sortType === 'country') {
            url += '/sorted-by-country';
        } else if (sortType === 'id') {
            url += '/sorted-by-id';
        }

        const response = await fetch(url);
        if (response.ok) {
            const data = await response.json();
            setUniversities(data);
        } else {
            console.error('Error during fetch', response.statusText);
        } 
    };

    const handleHeaderClick = (field) => {
        setSortType(field);
    };

    return (
        <table border="1">
            <thead>
                <tr>
                    <th className="clickable" onClick={() => handleHeaderClick('id')}>ID</th>
                    <th className="clickable" onClick={() => handleHeaderClick('country')}>Country</th>
                    <th>University Name</th>
                    <th>Source</th>
                </tr>
            </thead>
            <tbody>
                {universities.map((university) => (
                    <tr key={university.id}>
                        <td>{university.id}</td>
                        <td>{university.country}</td>
                        <td>{university.universityName}</td>
                        <td>{university.source}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

export default UniversityTable;
