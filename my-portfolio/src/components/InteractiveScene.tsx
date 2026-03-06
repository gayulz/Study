/**
 * InteractiveScene - Three.js 기반 3D 은하수 파티클 배경
 * [신규생성/2025-03-06/작성자:gayul.kim]
 */

import { Canvas, useFrame } from '@react-three/fiber';
import { useRef, useMemo } from 'react';
import * as THREE from 'three';

// 형광 파티클 은하수
function GalaxyParticles() {
	const points = useRef<THREE.Points>(null);
	const count = 3000;

	const { positions, colors, sizes } = useMemo(() => {
		const positions = new Float32Array(count * 3);
		const colors = new Float32Array(count * 3);
		const sizes = new Float32Array(count);

		// 중간 톤 형광 색상 (글씨와 구분, 하지만 잘 보이게)
		const colorPalette = [
			new THREE.Color('#A855F7'), // 보라
			new THREE.Color('#8B5CF6'), // 보라
			new THREE.Color('#6366F1'), // 인디고
			new THREE.Color('#3B82F6'), // 블루
			new THREE.Color('#06B6D4'), // 시안
			new THREE.Color('#14B8A6'), // 틸
		];

		for (let i = 0; i < count; i++) {
			// 은하수 나선형 배치
			const radius = Math.random() * 18;
			const spinAngle = radius * 2;
			const branchAngle = ((i % 6) / 6) * Math.PI * 2;

			positions[i * 3] = Math.cos(branchAngle + spinAngle) * radius + (Math.random() - 0.5) * 3;
			positions[i * 3 + 1] = (Math.random() - 0.5) * 4;
			positions[i * 3 + 2] = Math.sin(branchAngle + spinAngle) * radius + (Math.random() - 0.5) * 3;

			// 랜덤 색상
			const color = colorPalette[Math.floor(Math.random() * colorPalette.length)];
			colors[i * 3] = color.r;
			colors[i * 3 + 1] = color.g;
			colors[i * 3 + 2] = color.b;

			// 적당한 크기
			sizes[i] = Math.random() * 0.06 + 0.02;
		}

		return { positions, colors, sizes };
	}, []);

	useFrame((state) => {
		if (!points.current) return;

		const time = state.clock.getElapsedTime();

		// 전체 은하 회전
		points.current.rotation.y = time * 0.03;

		// 마우스 반응
		const mouseX = state.mouse.x * 2;
		const mouseY = state.mouse.y * 2;
		points.current.rotation.x = mouseY * 0.1;
		points.current.rotation.z = mouseX * 0.05;
	});

	return (
		<points ref={points}>
			<bufferGeometry>
				<bufferAttribute
					attach="attributes-position"
					count={positions.length / 3}
					array={positions}
					itemSize={3}
				/>
				<bufferAttribute
					attach="attributes-color"
					count={colors.length / 3}
					array={colors}
					itemSize={3}
				/>
				<bufferAttribute
					attach="attributes-size"
					count={sizes.length}
					array={sizes}
					itemSize={1}
				/>
			</bufferGeometry>
			<pointsMaterial
				size={0.04}
				vertexColors
				transparent
				opacity={0.7}
				sizeAttenuation
				blending={THREE.AdditiveBlending}
				depthWrite={false}
			/>
		</points>
	);
}

// 떠다니는 형광 입자들
function FloatingParticles() {
	const points = useRef<THREE.Points>(null);
	const count = 100;

	const { positions, colors, sizes, velocities } = useMemo(() => {
		const positions = new Float32Array(count * 3);
		const colors = new Float32Array(count * 3);
		const sizes = new Float32Array(count);
		const velocities = new Float32Array(count * 3);

		const colorPalette = [
			new THREE.Color('#A855F7'), // 보라
			new THREE.Color('#8B5CF6'), // 보라
			new THREE.Color('#06B6D4'), // 시안
		];

		for (let i = 0; i < count; i++) {
			positions[i * 3] = (Math.random() - 0.5) * 20;
			positions[i * 3 + 1] = (Math.random() - 0.5) * 20;
			positions[i * 3 + 2] = (Math.random() - 0.5) * 20;

			const color = colorPalette[Math.floor(Math.random() * colorPalette.length)];
			colors[i * 3] = color.r;
			colors[i * 3 + 1] = color.g;
			colors[i * 3 + 2] = color.b;

			sizes[i] = Math.random() * 0.1 + 0.05;

			velocities[i * 3] = (Math.random() - 0.5) * 0.01;
			velocities[i * 3 + 1] = (Math.random() - 0.5) * 0.01;
			velocities[i * 3 + 2] = (Math.random() - 0.5) * 0.01;
		}

		return { positions, colors, sizes, velocities };
	}, []);

	useFrame(() => {
		if (!points.current) return;

		const positions = points.current.geometry.attributes.position.array as Float32Array;

		for (let i = 0; i < count; i++) {
			positions[i * 3] += velocities[i * 3];
			positions[i * 3 + 1] += velocities[i * 3 + 1];
			positions[i * 3 + 2] += velocities[i * 3 + 2];

			// 경계 밖으로 나가면 반대편으로
			if (Math.abs(positions[i * 3]) > 10) positions[i * 3] *= -1;
			if (Math.abs(positions[i * 3 + 1]) > 10) positions[i * 3 + 1] *= -1;
			if (Math.abs(positions[i * 3 + 2]) > 10) positions[i * 3 + 2] *= -1;
		}

		points.current.geometry.attributes.position.needsUpdate = true;
	});

	return (
		<points ref={points}>
			<bufferGeometry>
				<bufferAttribute
					attach="attributes-position"
					count={positions.length / 3}
					array={positions}
					itemSize={3}
				/>
				<bufferAttribute
					attach="attributes-color"
					count={colors.length / 3}
					array={colors}
					itemSize={3}
				/>
				<bufferAttribute
					attach="attributes-size"
					count={sizes.length}
					array={sizes}
					itemSize={1}
				/>
			</bufferGeometry>
			<pointsMaterial
				size={0.08}
				vertexColors
				transparent
				opacity={0.75}
				sizeAttenuation
				blending={THREE.AdditiveBlending}
				depthWrite={false}
			/>
		</points>
	);
}

// 메인 3D 씬
export default function InteractiveScene() {
	return (
		<div className="w-full h-full absolute inset-0">
			<Canvas
				camera={{ position: [0, 0, 8], fov: 75 }}
				style={{ background: 'transparent' }}
			>
				{/* 은하수 파티클 */}
				<GalaxyParticles />

				{/* 떠다니는 형광 입자 */}
				<FloatingParticles />
			</Canvas>
		</div>
	);
}
