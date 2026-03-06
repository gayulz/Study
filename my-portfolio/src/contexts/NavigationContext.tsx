/**
 * NavigationContext - 네비게이션 상태 관리
 * [신규생성/2025-03-06/작성자:gayul.kim]
 */

import { createContext, useContext, useState, ReactNode } from 'react';

export type SectionName = 'home' | 'about' | 'projects' | 'experience' | 'education' | 'certifications' | 'writing' | 'contact';

interface NavigationContextType {
	activeSection: SectionName;
	setActiveSection: (section: SectionName) => void;
}

const NavigationContext = createContext<NavigationContextType | undefined>(undefined);

export function NavigationProvider({ children }: { children: ReactNode }) {
	const [activeSection, setActiveSection] = useState<SectionName>('home');

	return (
		<NavigationContext.Provider value={{ activeSection, setActiveSection }}>
			{children}
		</NavigationContext.Provider>
	);
}

export function useNavigation() {
	const context = useContext(NavigationContext);
	if (context === undefined) {
		throw new Error('useNavigation must be used within a NavigationProvider');
	}
	return context;
}
