/**
 * ThemeContext - 다크/라이트 모드 전역 상태 관리
 * [신규생성/2025-03-06/작성자:gayul.kim]
 */

import { createContext, useContext, useEffect, useState, ReactNode } from 'react';

type Theme = 'light' | 'dark';

interface ThemeContextType {
	theme: Theme;
	toggleTheme: () => void;
}

const ThemeContext = createContext<ThemeContextType | undefined>(undefined);

export function ThemeProvider({ children }: { children: ReactNode }) {
	// localStorage에서 저장된 테마 불러오기 (기본값: light)
	const [theme, setTheme] = useState<Theme>(() => {
		const saved = localStorage.getItem('theme') as Theme;
		return saved || 'light';
	});

	useEffect(() => {
		// HTML 루트 요소에 dark 클래스 추가/제거
		const root = document.documentElement;
		if (theme === 'dark') {
			root.classList.add('dark');
		} else {
			root.classList.remove('dark');
		}
		// localStorage에 현재 테마 저장
		localStorage.setItem('theme', theme);
	}, [theme]);

	const toggleTheme = () => {
		setTheme((prev) => (prev === 'light' ? 'dark' : 'light'));
	};

	return (
		<ThemeContext.Provider value={{ theme, toggleTheme }}>
			{children}
		</ThemeContext.Provider>
	);
}

export function useTheme() {
	const context = useContext(ThemeContext);
	if (context === undefined) {
		throw new Error('useTheme must be used within a ThemeProvider');
	}
	return context;
}
